package ksiegarnia.ksiegarnia.Author;


import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/Authors")
public class AuthorController {


    private AuthorRepo authorRepo;

    public AuthorController(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    /**
     * Find all authors
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Author> getAll() {
        return authorRepo.findAll();
    }

    /**
     * Find all authors with specific name
     */
    @RequestMapping(value = "/name={name}", method = RequestMethod.GET)
    public List<Author> getName(@PathVariable String name) {
        return authorRepo.findByname(name);
    }

    @RequestMapping(value = "/id={authorId}", method = RequestMethod.GET)
    public List<Author> getAuthorId(@PathVariable Long authorId) {
        return authorRepo.findByauthorId(authorId);
    }
     /**
     * Update an existing record or create a new one if it doesnt exist
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public List<Author> update(@RequestBody Author author) {
        authorRepo.save(author);
        return authorRepo.findAll();
    }
    /**
     *  Delete an existing record by book id
     */
    @Transactional
    @RequestMapping(value = "/delete={authorId}", method = RequestMethod.DELETE)
    public List<Author> deleteByauthorId(@PathVariable Long authorId) {
        authorRepo.deleteByauthorId(authorId);
        return authorRepo.findAll();

    }
}
