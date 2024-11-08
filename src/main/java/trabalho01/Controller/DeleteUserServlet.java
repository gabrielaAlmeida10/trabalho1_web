package trabalho01.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trabalho01.Model.UserDAO;

import java.io.IOException;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("id");
        if (userId != null) {
            UserDAO userDAO = new UserDAO();
            boolean success = userDAO.deleteUser(Integer.parseInt(userId));
            if (success) {
                response.sendRedirect("userSuccess.jsp?message=Usuário%20deletado%20com%20sucesso");
            } else {
                response.sendRedirect("error.jsp?message=Erro%20ao%20deletar%20usuário");
            }
        } else {
            response.sendRedirect("error.jsp?message=ID%20do%20usuário%20não%20encontrado");
        }
    }
}
