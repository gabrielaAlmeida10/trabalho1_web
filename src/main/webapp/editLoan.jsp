<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Editar Empréstimo</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Editar Empréstimo</h1>
        <form action="editLoan" method="post">
            <input type="hidden" name="id" value="${loanDTO.id}">
			<p><strong>Nome do Usuário:</strong> ${loanDTO.userName}</p>
			<p><strong>Nome do Livro:</strong> ${loanDTO.bookName}</p>
			<label for="return_date"><strong>Data de Devolução:</strong></label>
			<input type="date" id="return_date" name="return_date" value="${loanDTO.returnDate != null ? loanDTO.returnDate : ''}">
            <label for="returned"><strong>Devolvido:</strong></label>
    		<input type="checkbox" id="returned" name="returned" ${loanDTO.returned ? 'checked' : ''}>
            <button type="submit">Atualizar Status</button>
        </form>
        <a href="listLoans">Voltar para a lista de empréstimos</a>
    </div>
</body>
</html>
