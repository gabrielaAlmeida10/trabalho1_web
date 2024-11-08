<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erro</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Oops! Algo deu errado.</h1>
        <p>Desculpe, mas não conseguimos encontrar a página ou recurso que você está procurando.</p>

        <h2>Detalhes do Erro:</h2>
        <p><strong>Status do Erro:</strong> ${requestScope['javax.servlet.error.status_code']}</p>
        <p><strong>Descrição:</strong> ${requestScope['javax.servlet.error.message']}</p>
        <p><strong>Tipo de Erro:</strong> ${requestScope['javax.servlet.error.exception_type']}</p>
        <p><strong>URL de Origem:</strong> ${requestScope['javax.servlet.error.request_uri']}</p>

        <a href="index.jsp">Voltar para a Página Inicial</a>
    </div>
</body>
</html>
