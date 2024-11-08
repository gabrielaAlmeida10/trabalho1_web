<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuário</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Editar Usuário</h1>
        <form action="editUser" method="post">
            <input type="hidden" name="id" value="${user.id}">

            <label for="name">Nome:</label>
            <input type="text" id="name" name="name" value="${user.name}" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user.email}" required>

            <label for="phone">Telefone:</label>
            <input type="text" id="phone" name="phone" value="${user.phone}" required>

            <button type="submit">Salvar Alterações</button>
        </form>
        <a href="userList.jsp">Voltar à lista de usuários</a>
    </div>
</body>
</html>
