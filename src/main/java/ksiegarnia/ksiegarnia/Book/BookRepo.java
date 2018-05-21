package ksiegarnia.ksiegarnia.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *define repository functions
 */
@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findBytitle(String title);
    List<Book> findByauthorId (Long authorId);
    List<Book> deleteBybookId (Long bookId);
}
