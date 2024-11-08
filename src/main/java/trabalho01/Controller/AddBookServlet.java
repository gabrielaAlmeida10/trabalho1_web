package trabalho01.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trabalho01.Model.BookDAO;
import trabalho01.Model.BookDTO;

import java.io.IOException;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {

    private BookDAO bookDAO;

    @Override
    public void init() throws ServletException {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando os parâmetros do formulário
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String genre = request.getParameter("genre");
        int year = Integer.parseInt(request.getParameter("year"));
        int qtd = Integer.parseInt(request.getParameter("qtd"));

        // Criando o objeto BookDTO
        BookDTO book = new BookDTO(0, title, author, publisher, genre, year, qtd);

        // Adicionando o livro ao banco de dados
        bookDAO.addBook(book);

        // Redirecionando para a página de sucesso
        response.sendRedirect("createBookSuccess.jsp");
    }
}
