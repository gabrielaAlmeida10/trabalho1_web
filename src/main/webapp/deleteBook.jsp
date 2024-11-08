<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Excluir Livro</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Excluir Livro</h1>
        <p>Você tem certeza que deseja excluir o livro <strong>${book.title}</strong>?</p>
        <form action="deleteBook" method="post">
            <input type="hidden" name="id" value="${book.id}">
            <button type="submit">Sim, excluir</button>
            <a href="listBooks">Cancelar</a>
        </form>
    </div>
</body>
</html>
