package trabalho01.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import trabalho01.Database;

public class BookDAO {
    public void addBook(BookDTO book) {
        String sql = "INSERT INTO books (title, author, publisher, genre, years, quantity) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getPublisher());
            stmt.setString(4, book.getGenre());
            stmt.setInt(5, book.getYear());
            stmt.setInt(6, book.getQtd());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<BookDTO> getAllBooks() {
        List<BookDTO> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String genre = rs.getString("genre");
                int year = rs.getInt("years");
                int qtd = rs.getInt("quantity");
                
                // Adicionando cada livro na lista
                books.add(new BookDTO(id, title, author, publisher, genre, year, qtd));
                System.out.println(books); // Verificar se os livros estão sendo adicionados
                System.out.println("Livros encontrados: " + books.size());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return books;
    }
    
    public boolean updateBook(BookDTO book) {
        String sql = "UPDATE books SET title = ?, author = ?, publisher = ?, genre = ?, years = ?, quantity = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getPublisher());
            stmt.setString(4, book.getGenre());
            stmt.setInt(5, book.getYear());  
            stmt.setInt(6, book.getQtd());   
            stmt.setInt(7, book.getId());    

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);  // Exibe o número de linhas afetadas
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar livro: " + e.getMessage());  // Adicionando mais detalhes sobre o erro
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteBook(int bookId) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public BookDTO getBookById(int id) {
        BookDTO book = null;
        String sql = "SELECT * FROM books WHERE id = ?";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Define o ID do livro como parâmetro na consulta SQL
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Se o livro for encontrado, cria o objeto BookDTO
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    String publisher = rs.getString("publisher");
                    String genre = rs.getString("genre");
                    int year = rs.getInt("years");
                    int qtd = rs.getInt("quantity");
                    
                    book = new BookDTO(id, title, author, publisher, genre, year, qtd);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return book;  // Retorna o livro encontrado ou null se não encontrado
    }
    
    public BookDTO getBookByName(String bookName) throws SQLException {
        String sql = "SELECT * FROM books WHERE title = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bookName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new BookDTO(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    rs.getString("genre"),
                    rs.getInt("years"),
                    rs.getInt("quantity")
                );
            } else {
                return null; // Nenhum livro encontrado
            }
        }
    }
    
    



}
