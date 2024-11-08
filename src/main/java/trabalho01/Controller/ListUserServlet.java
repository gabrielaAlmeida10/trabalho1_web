package trabalho01.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trabalho01.Model.UserDAO;
import trabalho01.Model.UserDTO;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ListUserServlet
 */
@WebServlet("/listUser")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
        List<UserDTO> users = userDAO.listUsers();  // Recupera a lista de usuários

        // Adiciona a lista de usuários como atributo da requisição
        request.setAttribute("users", users);

        // Redireciona para a página JSP que vai exibir a lista
        request.getRequestDispatcher("/listUser.jsp").forward(request, response);
    }
}
