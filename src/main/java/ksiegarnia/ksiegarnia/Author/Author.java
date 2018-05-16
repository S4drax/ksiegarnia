package ksiegarnia.ksiegarnia.Author;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Creates the Author entity and defines how the table should look
 *
 */
@Entity
@Table(name = "Author")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long authorId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
    /**
     * Author onstructor and definitions of get functions (so that rest functions can actually show them with findAll)
     */
    protected Author(){
        }
    public Author(long authorId, String name, String surname) {
        this.authorId = authorId;
        this.name = name;
        this.surname = surname;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    /**
    *override the standard view format
    */
    @Override
    public String toString(){
        return String.format("Author[authorId=%d, name='%s', surname='%s']", authorId, name, surname);
    }
}