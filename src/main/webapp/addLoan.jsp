<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Empréstimo</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Cadastro de Empréstimo</h1>
<form action="/trabalho1/addLoan" method="post">
            <label for="bookId">Nome do Livro:</label>
<input type="text" id="bookName" name="bookName" required>

            <label for="userId">Nome do Usuário:</label>
			<input type="text" id="userName" name="userName" required>

            <label for="loanDate">Data de Empréstimo:</label>
            <input type="date" id="loanDate" name="loanDate" required>

            <label for="returnDate">Data Prevista para Devolução:</label>
            <input type="date" id="returnDate" name="returnDate" required>

            <button type="submit">Cadastrar Empréstimo</button>
        </form>
    </div>
</body>
</html>
