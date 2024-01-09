package org.example.bookshop;

import lombok.RequiredArgsConstructor;
import org.example.bookshop.dao.AuthorDao;
import org.example.bookshop.dao.BookDao;
import org.example.bookshop.dao.GenreDao;
import org.example.bookshop.dao.PublisherDao;
import org.example.bookshop.entity.Author;
import org.example.bookshop.entity.Book;
import org.example.bookshop.entity.Genre;
import org.example.bookshop.entity.Publisher;
import org.example.bookshop.util.IsbnGenerator;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class BookShopApplication {

    private final AuthorDao authorDao;
    private final BookDao bookDao;
    private final GenreDao genreDao;
    @Bean
    @Transactional
    @Profile("data")
    public ApplicationRunner runner(){
        return r ->{
            Author author1 = new Author("Author Banana","AuBana@gmail.com");
            Author author2 = new Author("Author Orange","AuOrn@gmail.com");

            Publisher publisher1 = new Publisher("Publisher Banana","pubana@gmail.com");
            Publisher publisher2 = new Publisher("Publisher Orange","puboran@gmail.com");

            Genre genre1 = new Genre();
            genre1.setGenreName("Tragedy");

            Genre genre2 = new Genre();
            genre2.setGenreName("Adventure");

            Book book1 = new Book(
                    1,
                    IsbnGenerator.generate(),
                    "Oliver Twist","Excellent",
                    50.3,20,"https://source.unsplash.com/400x300/?hiking"
            );
            Book book2 = new Book(
                    2,
                    IsbnGenerator.generate(),
                    "Great Expectations","Good Choice",
                    30.9,20,"https://source.unsplash.com/400x300/?hiking"
            );
            Book book3 = new Book(
                    3,
                    IsbnGenerator.generate(),
                    "Blead House","Nice",
                    49.9,20,"https://source.unsplash.com/400x300/?hiking"
            );
            Book book4 = new Book(
                    4,
                    IsbnGenerator.generate(),
                    "Under The GreenWood Tree","Excellent",
                    27.9,20,"https://source.unsplash.com/400x300/?hiking"
            );
            Book book5 = new Book(
                    5,
                    IsbnGenerator.generate(),
                    "Return of the Native Expectations","Good Choice",
                    32.9,20,"https://source.unsplash.com/400x300/?hiking"
            );
            Book book6 = new Book(
                    6,
                    IsbnGenerator.generate(),
                    "Far From The Maddening Crowd","Good Choice",
                    40.9,20,"https://source.unsplash.com/400x300/?hiking"
            );

            // mapping
            // author + book
            author1.addBook(book1);
            author1.addBook(book2);
            author1.addBook(book3);

            author2.addBook(book4);
            author2.addBook(book5);
            author2.addBook(book6);

            Publisher pub1 = publisherDao.save(publisher1);
            pub1.addBook(book1);
            pub1.addBook(book2);
            pub1.addBook(book3);

            Publisher pub2 = publisherDao.save(publisher2);
            pub2.addBook(book4);
            pub2.addBook(book5);
            pub2.addBook(book6);

            Genre gen1 = genreDao.save(genre1);
            book1.addGeneres(gen1);
            book2.addGeneres(gen1);
            book3.addGeneres(gen1);

            Genre gen2 = genreDao.save(genre2);
            book4.addGeneres(gen2);
            book5.addGeneres(gen2);
            book6.addGeneres(gen2);

//            bookDao.save(book1);
//            bookDao.save(book2);
//            bookDao.save(book3);
//            bookDao.save(book4);
//            bookDao.save(book5);
//            bookDao.save(book6);

            authorDao.save(author1);
            authorDao.save(author2);

        };
    }

    private final PublisherDao publisherDao;

    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);
    }

}
