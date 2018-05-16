package ksiegarnia.ksiegarnia.Author;


import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Author> getAll() {
        return authorRepo.findAll();
    }

    /**
     * Find all authors with specific name
     */
    @RequestMapping(value = "/name/{im}", method = RequestMethod.GET)
    public List<Author> getName(@PathVariable String im) {
        return authorRepo.findByname(im);
    }

    /**
     * Add a new author record to the database
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Author> create(@RequestBody Author author) {
        authorRepo.save(author);
        return authorRepo.findAll();
    }

    /**
     * Update an existing record
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public List<Author> update(@RequestBody Author author) {
        authorRepo.save(author);
        return authorRepo.findAll();
    }
}
