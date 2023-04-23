<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    </style>

    <h1 id="title" class="yes"></h1>
    <button id="btnToggler">Click-me</button>
    
    <script src="script.js?random=<? time() ?>"></script>
</body>
</html>