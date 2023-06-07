document.addEventListener("DOMContentLoaded", function() {
  const fileName = "dadosDeEntrada.csv";
  const reader = new FileReader();
  const tabela = document.getElementById("tabela-dados");

  // Função para atualizar o arquivo CSV
  function updateCSV() {
    const tableRows = Array.from(document.querySelectorAll("#tabela-dados tr"));
    const headers = tableRows.shift().querySelectorAll("th");
    const rows = tableRows.map(row => row.querySelectorAll("td"));

    const newContents = [];
    newContents.push(Array.from(headers).map(th => th.textContent).join(";"));

    rows.forEach(row => {
      const rowData = Array.from(row).map(td => td.textContent);
      newContents.push(rowData.join(";"));
    });

    const newCSV = newContents.join("\n");
    
    fetch(fileName, {
      method: "PUT", // Você pode ajustar o método HTTP conforme necessário (exemplo: PUT, POST)
      body: newCSV
    })
    .then(response => {
      if (!response.ok) {
        throw new Error("Failed to update CSV file");
      }
      console.log("CSV file updated successfully");
    })
    .catch(error => {
      console.error(error);
    });
  }

  // Manipuladores de eventos para arrastar e soltar
  let draggingElement = null;

  function handleDragStart(event) {
    draggingElement = event.target;
    event.dataTransfer.effectAllowed = "move";
    event.dataTransfer.setData("text/html", event.target.outerHTML);
    event.target.classList.add("dragging");
  }

  function handleDragEnter(event) {
    event.target.classList.add("drag-over");
  }

  function handleDragLeave(event) {
    event.target.classList.remove("drag-over");
  }

  function handleDragOver(event) {
    event.preventDefault();
    event.dataTransfer.dropEffect = "move";
  }

  function handleDrop(event) {
    event.preventDefault();
    event.stopPropagation();
    event.target.classList.remove("drag-over");

    if (draggingElement !== event.target) {
      draggingElement.outerHTML = event.target.outerHTML;
      event.target.outerHTML = event.dataTransfer.getData("text/html");
      updateCSV();
    }
  }

  function handleDragEnd(event) {
    draggingElement.classList.remove("dragging");
    draggingElement = null;
  }

  // Adicionando manipuladores de eventos após o carregamento do DOM
  tabela.addEventListener("dragstart", handleDragStart);
  tabela.addEventListener("dragenter", handleDragEnter);
  tabela.addEventListener("dragleave", handleDragLeave);
  tabela.addEventListener("dragover", handleDragOver);
  tabela.addEventListener("drop", handleDrop);
  tabela.addEventListener("dragend", handleDragEnd);

  // Lendo o arquivo CSV
  fetch(fileName)
    .then(response => {
      if (!response.ok) {
        throw new Error("Failed to fetch file");
      }
      return response.text();
    })
    .then(text => reader.readAsText(new Blob([text]), "UTF-8"))
    .catch(error => {
      console.error(error);
    });

  reader.onload = function(e) {
    const contents = e.target.result;
    const rows = contents.split("\n");

    if (rows.length > 0) {
      const headerRow = document.createElement("tr");
      const headers = rows[0].split(";");

      for (let i = 0; i < headers.length; i++) {
        const th = document.createElement("th");
        th.textContent = headers[i];
        headerRow.appendChild(th);
      }

      tabela.appendChild(headerRow);

      for (let i = 1; i < rows.length; i++) {
        const rowData = rows[i].split(";");
        const row = document.createElement("tr");

        for (let j = 0; j < rowData.length; j++) {
          const td = document.createElement("td");
          td.textContent = rowData[j];
          row.appendChild(td);
        }

        tabela.appendChild(row);
      }
    }
  };
});
