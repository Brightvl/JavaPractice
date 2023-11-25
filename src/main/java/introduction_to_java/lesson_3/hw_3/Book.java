package introduction_to_java.lesson_3.hw_3;


public class Book {
    String bookName;
    String surname;
    int price;
    int yearPublication;
    int numberPages;


    public Book(String bookName, String surname, int price, int yearPublication, int numberPages) {
        this.bookName = bookName;
        this.surname = surname;
        this.price = price;
        this.yearPublication = yearPublication;
        this.numberPages = numberPages;
    }

    @Override
    public String toString() {
        return "{bookName='" + bookName + '\'' +
                ", surname='" + surname + '\'' +
                ", price=" + price +
                ", yearPublication=" + yearPublication +
                ", numberPages=" + numberPages + "}";
    }
}

