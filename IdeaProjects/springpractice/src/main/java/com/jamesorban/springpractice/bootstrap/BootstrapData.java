package com.jamesorban.springpractice.bootstrap;

import com.jamesorban.springpractice.dormain.Author;
import com.jamesorban.springpractice.dormain.Book;
import com.jamesorban.springpractice.dormain.Publisher;
import com.jamesorban.springpractice.repositories.AuthorRepository;
import com.jamesorban.springpractice.repositories.BookRepository;
import com.jamesorban.springpractice.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Aboki Publishing");
        publisher.setState("Benue");
        publisher.setAddressLine1("High level Makurdi");
        publisher.setZip("FKP");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count" + publisherRepository.count());


        Author James = new Author("James", "Orban");
        Book Java = new Book("Absolute Java", "0512354");
        James.getBooks().add(Java);
        Java.getAuthors().add(James);

        Java.setPublisher(publisher);
        publisher.getBooks().add(Java);

        authorRepository.save(James);
        bookRepository.save(Java);
        publisherRepository.save(publisher);

        Author Dotman = new Author("Dotman", "Ogun");
        Book Python = new Book("Critical Thinking", "132678");
        Dotman.getBooks().add(Python);
        Python.getAuthors().add(Dotman);

        Python.setPublisher(publisher);
        publisher.getBooks().add(Python);

        authorRepository.save(Dotman);
        bookRepository.save(Python);
        publisherRepository.save(publisher);


    System.out.println("Number of Books" + bookRepository.count());
    System.out.println("Publisher Number of Books" + publisher.getBooks().size());
    }
}
