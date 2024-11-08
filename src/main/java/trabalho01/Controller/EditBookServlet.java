package trabalho01.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trabalho01.Model.BookDAO;
import trabalho01.Model.BookDTO;

import java.io.IOException;

/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/editBook")
public class EditBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("id");  // Obtém o ID do livro da URL
        if (bookId != null) {
            BookDAO bookDAO = new BookDAO();
            BookDTO book = bookDAO.getBookById(Integer.parseInt(bookId));  // Obtém o livro pelo ID
            if (book != null) {
                request.setAttribute("book", book);  // Adiciona o livro à requisição
                RequestDispatcher dispatcher = request.getRequestDispatcher("editBook.jsp");  // Encaminha para a página de edição
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("listBooks.jsp");  // Se não encontrar o livro, redireciona para a lista
            }
        } else {
            response.sendRedirect("listBooks.jsp");  // Se o ID não for fornecido, redireciona para a lista
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera os dados do formulário
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String genre = request.getParameter("genre");
        int year = Integer.parseInt(request.getParameter("year"));
        int quantity = Integer.parseInt(request.getParameter("qtd"));

        // Log para verificar os dados recebidos
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("Genre: " + genre);
        System.out.println("Year: " + year);
        System.out.println("Quantity: " + quantity);

        // Cria um objeto BookDTO com os dados do formulário
        BookDTO book = new BookDTO(id, title, author, publisher, genre, year, quantity);

        // Chama o método de atualização no DAO
        BookDAO bookDAO = new BookDAO();
        boolean updated = bookDAO.updateBook(book);

        if (updated) {
            response.sendRedirect("listBooks"); // Redireciona para a lista de livros após a atualização
        } else {
            response.getWriter().write("Erro ao atualizar o livro");
        }
    }

}

