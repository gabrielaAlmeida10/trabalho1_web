package trabalho01.Model;

import java.util.Date;

public class LoanDTO {
    private int id;
    private String userName;
    private String bookName;
    private java.util.Date loanDate;
    private java.util.Date returnDate;
    private boolean isReturned;

    // Getters e Setters para cada campo
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public java.util.Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(java.util.Date loanDate) {
        this.loanDate = loanDate;
    }

    public java.util.Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(java.util.Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}
