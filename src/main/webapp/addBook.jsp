<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Livro</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Adicionar Livro</h1>
        <form action="addBook" method="post">
            <label for="title">T�tulo:</label>
            <input type="text" id="title" name="title" required>

            <label for="author">Autor:</label>
            <input type="text" id="author" name="author" required>

            <label for="publisher">Editora:</label>
            <input type="text" id="publisher" name="publisher" required>
            
            <label for="genre">Gen�ro:</label>
            <input type="text" id="genre" name="genre" required>
            
            <label for="year">Ano:</label>
            <input type="number" id="year" name="year" required>
            
            <label for="qtd">Quantidade:</label>
            <input type="number" id="qtd" name="qtd" required>

            <button type="submit">Adicionar Livro</button>
        </form>
        <a href="listBooks">Voltar para a lista de livros</a>
    </div>
</body>
</html>
