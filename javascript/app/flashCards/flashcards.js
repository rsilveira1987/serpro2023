const flashcardsWord = [
    { front: "Copiar", back: "Ctrl + C" },
    { front: "Recortar", back: "Ctrl + X" },
    { front: "Colar", back: "Ctrl + V" },
    { front: "Desfazer", back: "Ctrl + Z" },
    { front: "Refazer", back: "Ctrl + Y" },
    { front: "Negrito", back: "Ctrl + N" },
    { front: "Itálico", back: "Ctrl + I" },
    { front: "Sublinhado", back: "Ctrl + S" },
    { front: "Selecionar tudo", back: "Ctrl + A" },
    { front: "Salvar", back: "Ctrl + B" },
    { front: "Abrir", back: "Ctrl + O" },
    { front: "Imprimir", back: "Ctrl + P" },
    { front: "Localizar", back: "Ctrl + L" },
    { front: "Substituir", back: "Ctrl + U" },
    { front: "Recuar parágrafo", back: "Ctrl + R" },
    { front: "Alinhar à esquerda", back: "Ctrl + E" },
    { front: "Alinhar ao centro", back: "Ctrl + T" },
    { front: "Alinhar à direita", back: "Ctrl + D" },
    { front: "Inserir hyperlink", back: "Ctrl + K" },
    { front: "Desfazer formatação", back: "Ctrl + Espaço" }
];

// Exportando o array de flashcards para ser utilizado em outros arquivos
if (typeof module !== 'undefined' && typeof module.exports !== 'undefined') {
    module.exports = flashcardsWord;
}

