
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

function flipCard(card) {
    card.classList.toggle("flipped");
}

