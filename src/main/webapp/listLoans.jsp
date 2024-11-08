<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="trabalho01.Model.LoanDTO" %> 
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Empréstimos</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Lista de Empréstimos</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Livro</th>
            <th>Usuário</th>
            <th>Data do Empréstimo</th>
            <th>Status</th>
            <th>Ações</th>
        </tr>
        <%
            // Recupera a lista de empréstimos passada pelo Servlet
            List<LoanDTO> loans = (List<LoanDTO>) request.getAttribute("loans");
            
            // Verifica se a lista de empréstimos não está vazia
            if (loans != null && !loans.isEmpty()) {
                // Itera sobre a lista de empréstimos
                for (LoanDTO loan : loans) {
        %>
                    <tr>
                        <td><%= loan.getId() %></td>
                        <td><%= loan.getBookName() %></td>
                        <td><%= loan.getUserName() %></td>
                        <td><%= loan.getLoanDate() %></td>
                        <td><%= loan.isReturned() ? "Devolvido" : "Em andamento" %></td>
                        <td>
							<% if (!loan.isReturned()) { %>
							    <a href="editLoan?loanId=<%= loan.getId() %>&action=updateStatus">Atualizar Status</a>
							<% } %>                     
						</td>
                    </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="6">Nenhum empréstimo encontrado.</td>
            </tr>
        <%  
            }
        %>
    </table>
</body>
</html>
