<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Atualizar Status de Empréstimo</title>
</head>
<body>
    <h2>Atualizar Status de Empréstimo</h2>
    <form action="loan" method="post">
        <input type="hidden" name="action" value="updateStatus">
        
        <label for="loanId">ID do Empréstimo:</label>
        <input type="text" name="loanId" id="loanId" required>

        <label for="isReturned">Devolvido:</label>
        <select name="isReturned" id="isReturned">
            <option value="true">Sim</option>
            <option value="false">Não</option>
        </select>

        <button type="submit">Atualizar Status</button>
    </form>
</body>
</html>
