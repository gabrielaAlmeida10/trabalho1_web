<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Usuário</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Cadastrar Usuário</h1>
        <form action="addUser" method="post">
            <label for="name">Nome:</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Phone:</label>
            <input type="text" id="phone" name="phone" required>

            <button type="submit">Cadastrar</button>
        </form>
    </div>
</body>
</html>
