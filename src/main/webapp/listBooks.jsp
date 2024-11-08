<%@ page import="java.util.List" %>
<%@ page import="trabalho01.Model.BookDTO" %> 
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Livros</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Lista de Livros</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Editora</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    // Obtenha a lista de livros do atributo de requisição
                    List<BookDTO> books = (List<BookDTO>) request.getAttribute("books");
                    if (books != null) {
                        for (BookDTO book : books) {
                %>
                    <tr>
                        <td><%= book.getId() %></td>
                        <td><%= book.getTitle() %></td>
                        <td><%= book.getAuthor() %></td>
                        <td><%= book.getPublisher() %></td>
                        <td>
                            <a href="editBook?id=<%= book.getId() %>">Editar</a> | 
                            <a href="deleteBook?id=<%= book.getId() %>" onclick="return confirm('Tem certeza que deseja excluir?')">Excluir</a>
                        </td>
                    </tr>
                <% 
                        } 
                    } else { 
                %>
                    <tr>
                        <td colspan="5">Nenhum livro encontrado.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        <a href="addBook.jsp">Adicionar Novo Livro</a>
       <a href="index.jsp">Voltar a página inicial</a>
        
    </div>
</body>
</html>
