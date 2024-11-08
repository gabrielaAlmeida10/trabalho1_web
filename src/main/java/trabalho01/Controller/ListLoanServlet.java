package trabalho01.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trabalho01.Model.LoanDAO;
import trabalho01.Model.LoanDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/listLoans")
public class ListLoanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private LoanDAO loanDAO;

    @Override
    public void init() throws ServletException {
        loanDAO = new LoanDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<LoanDTO> loans = loanDAO.getAllLoans();
            System.out.println("Empréstimos recuperados: " + loans.size());  // Verifica a quantidade de empréstimos recuperados
            request.setAttribute("loans", loans);  // Passa a lista de empréstimos para a JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("listLoans.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao consultar os empréstimos.");
        }
    }

}
