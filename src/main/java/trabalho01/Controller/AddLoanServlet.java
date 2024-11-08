package trabalho01.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trabalho01.Database;
import trabalho01.Model.BookDAO;
import trabalho01.Model.BookDTO;
import trabalho01.Model.LoanDAO;
import trabalho01.Model.LoanDTO;
import trabalho01.Model.UserDAO;
import trabalho01.Model.UserDTO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/addLoan")
public class AddLoanServlet extends HttpServlet {

    private LoanDAO loanDAO;
    private BookDAO bookDAO;  // Supondo que você tenha um DAO para livros
    private UserDAO userDAO;  // Supondo que você tenha um DAO para usuários

    @Override
    public void init() throws ServletException {
        loanDAO = new LoanDAO();
        bookDAO = new BookDAO();  // Inicializa o BookDAO
        userDAO = new UserDAO();  // Inicializa o UserDAO
    }
    public void addLoan(LoanDTO loan) throws SQLException {
        String sql = "INSERT INTO loans (user_name, book_name, loan_date, returned) VALUES (?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, loan.getUserName());
            stmt.setString(2, loan.getBookName());
            stmt.setTimestamp(3, new java.sql.Timestamp(loan.getLoanDate().getTime()));
            stmt.setBoolean(4, loan.isReturned());

            stmt.executeUpdate();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookName");
        String userName = request.getParameter("userName");

        if (bookName == null || bookName.trim().isEmpty() || userName == null || userName.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome do livro ou do usuário não fornecido.");
            return;
        }

        BookDTO book = null;
        UserDTO user = null;

        try {
            book = bookDAO.getBookByName(bookName);
            if (book == null) {
                throw new SQLException("Livro não encontrado: " + bookName);
            }
            user = userDAO.getUserByName(userName);
            if (user == null) {
                throw new SQLException("Usuário não encontrado: " + userName);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe a exceção no console
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao consultar o banco de dados: " + e.getMessage());
            return;
        }

        LoanDTO loan = new LoanDTO();
        loan.setBookName(book.getTitle());  // Usando título do livro
        loan.setUserName(user.getName());  // Usando nome do usuário
        loan.setLoanDate(new Date());
        loan.setReturned(false);

        try {
            loanDAO.addLoan(loan);
            response.sendRedirect("loanSuccess.jsp");
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe a exceção no console
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao adicionar empréstimo: " + e.getMessage());
        }
    }
}
