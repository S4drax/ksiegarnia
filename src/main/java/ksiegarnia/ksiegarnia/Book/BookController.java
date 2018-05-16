package ksiegarnia.ksiegarnia.Book;

import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    /**
     * Find all books with specific title
     */
    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    public List<Book> getTitle(@PathVariable String title) {
        return bookRepo.findBytitle(title);
    }

    /**
     * Find all books of an author with specific id
     */
    @RequestMapping(value = "/authorId/{authorId}", method = RequestMethod.GET)
    public List<Book> getAuthorId(@PathVariable Long authorId) {
        return bookRepo.findByauthorId(authorId);
    }

    /**
     * Add a new book record to the database
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Book> create(@RequestBody Book book) {
        bookRepo.save(book);
        return bookRepo.findAll();
    }

    /**
     * Update an existing record
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public List<Book> update(@RequestBody Book book) {
        bookRepo.save(book);
        return bookRepo.findAll();
    }
}
