package trabalho01.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trabalho01.Model.BookDAO;

import java.io.IOException;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        
        BookDAO bookDAO = new BookDAO();
        boolean success = bookDAO.deleteBook(bookId);
        
        if (success) {
            response.sendRedirect("deleteBookSuccess.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
