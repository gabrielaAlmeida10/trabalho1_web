package trabalho01.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trabalho01.Model.UserDAO;
import trabalho01.Model.UserDTO;

import java.io.IOException;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id")); // Recuperando o ID do usuário

        // Buscando o usuário no banco de dados usando o ID
        UserDAO userDAO = new UserDAO();
        UserDTO user = userDAO.getUserById(userId);

        // Colocando o objeto usuário na requisição para usar no formulário
        request.setAttribute("user", user);

        // Redirecionando para a página de edição
        request.getRequestDispatcher("editUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Atualizando o usuário no banco de dados
        UserDTO user = new UserDTO(userId, name, email, phone);
        UserDAO userDAO = new UserDAO();
        boolean updated = userDAO.updateUser(user);

        if (updated) {
            response.sendRedirect("userSuccess.jsp"); // Redireciona para a página de sucesso
        } else {
            response.sendRedirect("error.jsp"); // Redireciona para uma página de erro caso não tenha sido atualizado
        }
    }
}
