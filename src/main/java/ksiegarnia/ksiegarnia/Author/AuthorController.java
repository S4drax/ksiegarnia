package ksiegarnia.ksiegarnia.Author;


import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/Author")
public class AuthorController {


    private AuthorRepo authorRepo;

    public AuthorController(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    /**
     * Find all authors
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Author> getAll(@RequestParam(value="name", required=false) String name) {
        if(name==null) {
            return authorRepo.findAll();
        } else {
            return authorRepo.findByname(name);
        }
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
    @RequestMapping(value = "/{authorId}", method = RequestMethod.DELETE)
    public List<Author> deleteByauthorId(@PathVariable Long authorId) {
        authorRepo.deleteByauthorId(authorId);
        return authorRepo.findAll();

    }
}
