package trabalho01.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trabalho01.Model.LoanDAO;
import trabalho01.Model.LoanDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/editLoan")
public class EditLoanServlet extends HttpServlet {

    private LoanDAO loanDAO;

    @Override
    public void init() throws ServletException {
        loanDAO = new LoanDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int loanId = Integer.parseInt(request.getParameter("loanId"));
            LoanDTO loanDTO = loanDAO.getLoanById(loanId);
            if (loanDTO != null) {
                request.setAttribute("loanDTO", loanDTO);  // Passa o LoanDTO para o JSP
                request.getRequestDispatcher("/editLoan.jsp").forward(request, response);
            } else {
                response.sendRedirect("error.jsp");  // Caso não encontre o empréstimo
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");  // Redireciona em caso de erro
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");  // Caso o loanId não seja um número válido
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int loanId = Integer.parseInt(request.getParameter("id"));
            Date returnDate = null;
            boolean returned = request.getParameter("returned") != null;  // Verifica se o checkbox foi marcado

            // Converte a data de devolução
            String returnDateStr = request.getParameter("return_date");
            if (returnDateStr != null && !returnDateStr.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                returnDate = sdf.parse(returnDateStr);
            }

            // Obtém o empréstimo existente e atualiza os campos necessários
            LoanDTO loanDTO = loanDAO.getLoanById(loanId);
            if (loanDTO != null) {
                loanDTO.setReturnDate(returnDate);
                loanDTO.setReturned(returned);  // Atualiza o status de devolução
                loanDAO.updateLoan(loanDTO);
                response.sendRedirect("listLoans");  // Redireciona para a lista de empréstimos
            } else {
                response.sendRedirect("error.jsp");  // Caso o empréstimo não seja encontrado
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");  // Redireciona para uma página de erro em caso de exceção
        }
    }



}
