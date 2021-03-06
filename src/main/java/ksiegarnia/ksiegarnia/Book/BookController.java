package ksiegarnia.ksiegarnia.Book;

import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/Books")
public class BookController {
    
    private BookRepo bookRepo;

    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    /**
     * Find all books
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Book> getAll(@RequestParam(value="title", required=false) String title) {
        if(title==null) {
            return bookRepo.findAll();
        } else {
            return bookRepo.findBytitle(title);
        }
    }
    /**
     * Find all books of an author with specific id
     */
    @RequestMapping(value = "/id={authorId}", method = RequestMethod.GET)
    public List<Book> getAuthorId(@PathVariable Long authorId) {
        return bookRepo.findByauthorId(authorId);
    }
    /**
     * Update an existing record or create new if it doesn't exist
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public List<Book> update(@RequestBody Book book) {
        bookRepo.save(book);
        return bookRepo.findAll();
    }

    /**
     *  Delete an existing record by book id
     */
    @Transactional
    @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
    public List<Book> deleteBybookId(@PathVariable Long bookId) {
        bookRepo.deleteBybookId(bookId);
        return bookRepo.findAll();

    }
}
