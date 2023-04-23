window.onload = function(e) {
    var works = true;
    var btn = document.getElementById("btnToggler");
    var h1 = document.getElementById("title");
    
    btnToggler.onclick = function(e){
        works = !works;

        h1.classList.remove("yes");
        h1.classList.remove("no");

        if (works) {
           h1.classList.add("yes");
        }

        if (!works) {
            h1.classList.add("no");
        }
    }
};
