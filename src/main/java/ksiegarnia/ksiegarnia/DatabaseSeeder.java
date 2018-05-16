package ksiegarnia.ksiegarnia;

import ksiegarnia.ksiegarnia.Author.Author;
import ksiegarnia.ksiegarnia.Author.AuthorRepo;
import ksiegarnia.ksiegarnia.Book.Book;
import ksiegarnia.ksiegarnia.Book.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private AuthorRepo authorRepo;
    private BookRepo bookRepo;

    public DatabaseSeeder(AuthorRepo authorRepo, BookRepo bookRepo){
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }
    /**
     *flood the empty database with pre-made data
     */
    @Override
    public void run(String... strings) throws Exception{
        authorRepo.save(new Author(1,"George", "Martin"));
        authorRepo.save(new Author(2,"Andrzej", "Sapkowski"));
        authorRepo.save(new Author(3, "R.A.","Salvatore"));
        bookRepo.save(new Book(1,1, "gra o tron"));
        bookRepo.save(new Book(2,1, "piesn lodu i ognia"));
        bookRepo.save(new Book(3,2, "pół wieku poezji"));
        bookRepo.save(new Book(4,2, "wiedźmin"));
        bookRepo.save(new Book(5,2, "hobbit"));
        bookRepo.save(new Book(6,2, "wiedźmin vol.2"));
        bookRepo.save(new Book(7,3, "legenda drizzta vol.1"));
        bookRepo.save(new Book(8,3, "legenda drizzta vol.2"));
        bookRepo.save(new Book(9,3, "legenda drizzta vol.3"));
        bookRepo.save(new Book(10,3, "legenda drizzta vol.4"));
        bookRepo.save(new Book(11,3, "kantyczka cadderlyego"));
    }


}
