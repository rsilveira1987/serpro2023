window.onload = function(e) {
    var works = true;
    var btn = document.getElementById("btnToggler");
    var h1 = document.getElementById("title");
    let x;
    btnToggler.onclick = function(e){
        works = !works;

        h1.classList.remove("yes");
        h1.classList.remove("no");
	

        if (works) {
	   h1.classList.add("yes");
           let num;
           num = 2+2;
           console.log(num);
           h1.insertAdjacentHTML("afterbegin","<div id='kkk'>afterbegin: "+num+"</div>");
	   x = document.getElementById("kkk");
//	   x.remove();
        }

        if (!works) {
            console.log("aaaa: "+x.innerhtml);            
            h1.classList.add("no");
        }

    }
};
