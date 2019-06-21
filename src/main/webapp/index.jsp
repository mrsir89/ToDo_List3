<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>To-Do</title>
    <style>
        body{
            margin: 0;
        }
        a{
            color: black;
            text-decoration: none;
        }
        h1{
            font-size: 45px;
            text-align: center;
            border-bottom: 2px solid gray;
            margin: 0;
            padding:20px;
        }
        ol{
            border-right: 2px solid gray;
            width: 100px;
            margin: 0;
            padding: 20px;
        }
        #grid{
            display: grid;
            grid-template-columns: 150px 1fr;
        }
        #grid ol{
            padding-left: 33px;
        }
        #article{
            padding-left: 25px;
        }

        @media(max-width:800px) {
            #grid{
                display: block;
            }
            ol{
                border-right: none;
            }
            h1{
                border-bottom: none;
            }
        }
    </style>

</head>

<body>
<h1><a>To Do List</a></h1>
<div id="grid">
    <ol>
        <li><a href="http://localhost:8080/ToDoList/test">Things</a></li>
        <li><a href="http://localhost:8080/ToDoList/test">PROJECT</a></li>
    </ol>
    <div id="article">
        <h2>Things</h2>
        <p>MAKE "To Do List"</p>
    </div>
</div>
</body>
</html>