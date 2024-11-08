package trabalho01.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trabalho01.Model.BookDAO;
import trabalho01.Model.BookDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/listBooks")
public class ListBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entrou no método doGet do ListBookServlet");  // Verificar se o servlet está sendo chamado
        BookDAO bookDAO = new BookDAO();
        List<BookDTO> books = bookDAO.getAllBooks();
        System.out.println("Quantidade de livros retornada pelo DAO: " + books.size());

        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listBooks.jsp");
        dispatcher.forward(request, response);
    }

}
