package trabalho01.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trabalho01.Model.UserDAO;
import trabalho01.Model.UserDTO;

import java.io.IOException;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Crie um novo objeto UserDTO com os dados fornecidos
        UserDTO user = new UserDTO(0, name, email, phone);

        // Chame o método de adicionar usuário no DAO
        UserDAO userDAO = new UserDAO();
        userDAO.addUser(user);

        // Redireciona para a página de sucesso
        response.sendRedirect("userSuccess.jsp");
    }
}

