package ksiegarnia.ksiegarnia.Book;

import javax.persistence.*;

/**
 * Creates the Book entity and defines how the table should look
 *
 */
@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long bookId;

    @Column(name="authorId")
    private long authorId;

    @Column(name="title")
    private String title;

    /**
     * Book onstructor and definitions of get functions (so that rest functions can actually show them with findAll)
     */
    protected  Book(){
        }
    public Book(long bookId, long authorId, String title){
        this.bookId=bookId;
        this.authorId=authorId;
        this.title=title;
    }

    public long getBookId(){
        return bookId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public String gettitle() {
        return title;
    }
    /**
     *override the standard view format
     */
    @Override
    public String toString(){
        return String.format("Author[bookId=%d, authorId=%d, title='%s']",bookId, authorId, title);
    }
}
