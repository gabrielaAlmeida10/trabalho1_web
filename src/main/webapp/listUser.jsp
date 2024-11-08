<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="trabalho01.Model.UserDTO" %> 
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Usuários</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Lista de Usuários</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Ações</th>
            </tr>

            <% 
                // Obtendo a lista de usuários da requisição
                List<UserDTO> users = (List<UserDTO>) request.getAttribute("users");
                
                // Verificando se a lista não é nula ou vazia
                if (users != null && !users.isEmpty()) {
                    // Iterando sobre a lista de usuários
                    for (UserDTO user : users) {
            %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getName() %></td>
                <td><%= user.getEmail() %></td>
                <td>
                      <a href="editUser?id=<%= user.getId() %>">Editar</a>
                	  <a href="deleteUser?id=<%= user.getId() %>">Deletar</a>
                </td>
            </tr>
            <% 
                    }  // Fim do loop
                } else {
            %>
            <tr><td colspan="4">Nenhum usuário encontrado.</td></tr>
            <% 
                }  // Fim da verificação
            %>
        </table>
        <a href="addUser.jsp">Cadastrar Novo Usuário</a>
        <a href="index.jsp">Voltar a Página Inicial</a>
    </div>
</body>
</html>

