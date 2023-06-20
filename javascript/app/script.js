window.onload = function(e) {
    var works = true;
    var btnToggler = document.getElementById("btnToggler");
    var h1 = document.getElementById("title");
    
    btnToggler.onclick = function(e){
        console.log("ok");
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

    load();
};
