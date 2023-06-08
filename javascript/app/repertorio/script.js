document.addEventListener("DOMContentLoaded", function() {
  const fileName = "dadosDeEntrada.csv";
  const reader = new FileReader();
  const tabela = document.getElementById("sortable-table");


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
        row.classList = "drag-handle";
        

        for (let j = 0; j < rowData.length; j++) {
          const td = document.createElement("td");
          td.textContent = rowData[j];
          row.appendChild(td);
        }

        tabela.appendChild(row);
      }
    }
    enableDragAndDrop();
  };
  
//  Drag and Drop
function enableDragAndDrop() {
  const rows = document.querySelectorAll('#sortable-table tr');
  rows.forEach((row, index) => {
    // Verifica se o elemento tr não tem um elemento th como filho direto
    if (!row.querySelector('th') || !row.querySelector('th').parentNode.isSameNode(row)) {
      row.draggable = true;
      row.dataset.index = index; // Adiciona o atributo data-index para manter o índice original

      row.addEventListener('dragstart', (e) => {
        e.dataTransfer.setData('text/plain', row.dataset.index); // Armazena o índice original
        e.dataTransfer.effectAllowed = 'move';
        row.classList.add('dragging');
      });

      row.addEventListener('dragend', () => {
        row.classList.remove('dragging');
        updateTableOrder();
        // updateCSV();
      });

      row.addEventListener('dragover', (e) => {
        e.preventDefault();
        const draggingRow = document.querySelector('.dragging');

        if (draggingRow && draggingRow !== row) {
          const draggingIndex = parseInt(draggingRow.dataset.index);
          const targetIndex = parseInt(row.dataset.index);

          if (draggingIndex < targetIndex) {
            row.parentNode.insertBefore(draggingRow, row.nextSibling);
          } else {
            row.parentNode.insertBefore(draggingRow, row);
          }
          updateTableOrder();
        }
      });
    }
  });
}


function updateTableOrder() {
  const table = document.getElementById('sortable-table');
  const tbody = table.querySelector('tbody');
  
  // Verifica se o tbody já foi removido
  if (!tbody) return;

  const rows = tbody.querySelectorAll('tr');
  const newTbody = document.createElement('tbody');

  rows.forEach((row, index) => {
    const newRow = document.createElement('tr');
    const cells = row.querySelectorAll('td');

    cells.forEach(cell => {
      const newCell = document.createElement('td');
      newCell.textContent = cell.textContent;
      newRow.appendChild(newCell);
    });

    newTbody.appendChild(newRow);
  });

  // Limpa as linhas existentes
  while (tbody.firstChild) {
    tbody.removeChild(tbody.firstChild);
  }

  // Adiciona as novas linhas reordenadas
  table.appendChild(newTbody);
}



  
});
