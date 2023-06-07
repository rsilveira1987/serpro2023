
// import flashcardsWord from './flashcards.js';

const flashcardContainer = document.getElementById("flashcard-container");

flashcardsWord.forEach((flashcard, index) => {
    const card = document.createElement("div");
    card.classList.add("flashcard");
    card.addEventListener("click", () => flipCard(card));
    card.innerHTML = `
        <div class="front">${flashcard.front}</div>
        <div class="back">${flashcard.back}</div>        
    `;
    flashcardContainer.appendChild(card);
});

// function flipCard(card) {
//     card.classList.toggle("flipped");
// }


function flipCard(card) {
    card.classList.toggle("flipped");
    const back = card.querySelector(".back");
    const linkContainer = card.querySelector(".link-container");
    if (card.classList.contains("flipped")) {
        if (!linkContainer) {
            const newLinkContainer = document.createElement("div");
            newLinkContainer.classList.add("link-container");

            const acerteiLink = document.createElement("a");
            acerteiLink.textContent = "Acertei";
            acerteiLink.classList.add("acertei-link");
            acerteiLink.addEventListener("click", incrementarAcertos);

            const erreiLink = document.createElement("a");
            erreiLink.textContent = "Errei";
            erreiLink.classList.add("errei-link");
            erreiLink.addEventListener("click", incrementarErros);

            newLinkContainer.appendChild(acerteiLink);
            newLinkContainer.appendChild(erreiLink);

            back.appendChild(newLinkContainer);
        }
    } else {
        if (linkContainer) {
            linkContainer.remove();
        }
    }
}

function incrementarAcertos() {
    const contadorAcertos = document.getElementById("contador-acertos");
    let acertos = parseInt(contadorAcertos.textContent);
    acertos++;
    contadorAcertos.textContent = acertos;
}

function incrementarErros() {
    const contadorErros = document.getElementById("contador-erros");
    let erros = parseInt(contadorErros.textContent);
    erros++;
    contadorErros.textContent = erros;
}