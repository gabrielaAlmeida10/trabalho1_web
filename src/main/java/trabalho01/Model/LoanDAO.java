package trabalho01.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import trabalho01.Database;

public class LoanDAO {
	
	

	    // Adicione o método para adicionar empréstimo no banco
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



	    public List<LoanDTO> getAllLoans() throws SQLException {
	        List<LoanDTO> loans = new ArrayList<>();
	        String sql = "SELECT * FROM loans";

	        try (Connection conn = Database.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {

	            System.out.println("Conexão com o banco estabelecida.");  // Verifique se a conexão foi bem-sucedida

	            while (rs.next()) {
	                LoanDTO loan = new LoanDTO();
	                loan.setId(rs.getInt("id"));
	                loan.setUserName(rs.getString("user_name"));
	                loan.setBookName(rs.getString("book_name"));
	                loan.setLoanDate(rs.getDate("loan_date"));
	                loan.setReturnDate(rs.getDate("return_date"));
	                loan.setReturned(rs.getBoolean("returned"));

	                loans.add(loan);
	                System.out.println("Empréstimo adicionado: " + loan.getId());  // Verifica os empréstimos recuperados
	            }
	        }
	        return loans;
	    }

	    public LoanDTO getLoanById(int id) throws SQLException {
	        String sql = "SELECT * FROM loans WHERE id = ?";
	        LoanDTO loan = null;

	        try (Connection conn = Database.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setInt(1, id);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    loan = new LoanDTO();
	                    loan.setId(rs.getInt("id"));
	                    loan.setUserName(rs.getString("user_name"));
	                    loan.setBookName(rs.getString("book_name"));
	                    loan.setLoanDate(rs.getTimestamp("loan_date"));
	                    loan.setReturnDate(rs.getDate("return_date"));
	                    loan.setReturned(rs.getBoolean("returned"));
	                }
	            }
	        }
	        return loan;
	    }

	    public void updateLoan(LoanDTO loan) throws SQLException {
	        String sql = "UPDATE loans SET user_name = ?, book_name = ?, loan_date = ?, return_date = ?, returned = ? WHERE id = ?";

	        try (Connection conn = Database.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, loan.getUserName());
	            stmt.setString(2, loan.getBookName());
	            stmt.setTimestamp(3, new java.sql.Timestamp(loan.getLoanDate().getTime()));
	            stmt.setDate(4, loan.getReturnDate() != null ? new java.sql.Date(loan.getReturnDate().getTime()) : null);
	            stmt.setBoolean(5, loan.isReturned());
	            stmt.setInt(6, loan.getId());

	            stmt.executeUpdate();
	        }
	    }

}
