package trabalho01.Model;

public class BookDTO {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private String genre;
    private int year;
    private int qtd;

    public BookDTO(int id, String title, String author, String publisher, String genre, int year, int qtd) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.year = year;
        this.qtd = qtd;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
