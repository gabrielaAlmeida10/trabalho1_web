<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Livro</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Editar Livro</h1>
        <form action="editBook" method="post">
            <!-- ID do livro é mantido em um campo oculto -->
            <input type="hidden" name="id" value="${book.id}">

            <label for="title">Título:</label>
            <input type="text" id="title" name="title" value="${book.title}" required>

            <label for="author">Autor:</label>
            <input type="text" id="author" name="author" value="${book.author}" required>

            <label for="publisher">Editora:</label>
            <input type="text" id="publisher" name="publisher" value="${book.publisher}" required>

            <label for="genre">Gênero:</label>
            <input type="text" id="genre" name="genre" value="${book.genre}" required>

            <label for="year">Ano:</label>
            <input type="text" id="year" name="year" value="${book.year}" required>

            <label for="qtd">Quantidade:</label>
            <input type="text" id="qtd" name="qtd" value="${book.qtd}" required>

            <button type="submit">Atualizar Livro</button>
        </form>
        <a href="listBooks">Voltar para a lista de livros</a>
    </div>
</body>
</html>
