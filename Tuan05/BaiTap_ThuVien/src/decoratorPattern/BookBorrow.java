package decoratorPattern;

interface BookBorrow {
    void borrow();
}

//Mượn sách cơ bản
class BasicBookBorrow implements BookBorrow {
    private String bookTitle;
    private String borrower;

    public BasicBookBorrow(String bookTitle, String borrower) {
        this.bookTitle = bookTitle;
        this.borrower = borrower;
    }

    @Override
    public void borrow() {
        System.out.println(borrower + " đã mượn sách: " + bookTitle);
    }
}

