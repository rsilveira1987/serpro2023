<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="type.css">
    <title>Document</title>
</head>
<body>
    <style>
        .yes::after {
            display: block;
            content: 'Javascript works!';
        }
        .no::after {
            display: block;
            content: 'Javascript doesn\'t work!';
        }

        button {
            background-color: blueviolet;
            padding: .5rem 1.5rem;
            border: none;
            border-radius: 3rem;
            color: #FFFFFF;
            font-weight: bold;
        }
        button:hover {
            cursor: pointer;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }

    </style>

    <main>
        <h1 id="title" class="yes"></h1>
    
        <button id="btnToggler">Click-me now</button>

        <section>
            <h1 id="counter"></h1>
            <p>Contador</p>
            <div class="buttons">
                <button onclick="decrementCounter()"> - </button>
                <button onclick="incrementCounter()"> + </button>
                <button onclick="reset()"> Reset </button>
            </div>
        </section>

    </main>
    
    
    <script src="script.js?random=<? time() ?>"></script>
    <script>
        const counter = document.getElementById("counter");

        function reset() {
            localStorage.counter = 0;
            load();
        }

        function incrementCounter() {
            if(localStorage.counter) {
                localStorage.counter = Number(localStorage.counter) + 1;
            } else {
                localStorage.counter = 0;
            }

            load();
        }

        function decrementCounter() {
            if(localStorage.counter) {
                if (Number(localStorage.counter) == 0)
                    return;
                localStorage.counter = Number(localStorage.counter) - 1;
            } else {
                localStorage.counter = 0;
            }
            
            load();
        }
        
        function load() {
            if(localStorage.counter) {
                counter.innerHTML = parseInt(localStorage.counter);
            } else {
                counter.innerHTML = 0;
            }
        }

    </script>
</body>
</html>