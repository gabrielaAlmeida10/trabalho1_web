package trabalho01; // Certifique-se de que o pacote corresponda ao seu projeto

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseTest {
    public static void main(String[] args) {
        System.out.println("Tentando conectar ao banco de dados...");
        try (Connection conn = Database.getConnection()) {
            if (conn != null) {
                System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Falha ao conectar ao banco de dados:");
            e.printStackTrace();
        }
    }
}
