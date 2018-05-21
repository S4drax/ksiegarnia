package ksiegarnia.ksiegarnia.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *define repository functions
 */
@Repository
public interface AuthorRepo extends JpaRepository<Author, Long>{
    List<Author> findByname(String name);
    List<Author> findByauthorId (Long authorId);
    List<Author> deleteByauthorId (Long authorId);
}
