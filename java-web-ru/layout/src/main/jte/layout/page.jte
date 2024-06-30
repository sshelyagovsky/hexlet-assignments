@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Hello Hexlet!</title>
    <style>
        ul {
            list-style: none;
            margin: 0;
            padding-left: 0;
        }
        li {
            display: inline;
        }
        a {
            text-decoration: none;
        }
        nav {
            display: block;
            margin-left: 100px;
        }
    </style>
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="/">Main page</a></li>
                <li><a href="/users">Users</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <div class="mx-auto p-4 py-md-5">
            <h6>${content}</h6>
        </div>
    </main>
    <footer>
        <a href="https://github.com/sshelyagovsky">Github profile 2024</a>
    </footer>
</body>
</html>