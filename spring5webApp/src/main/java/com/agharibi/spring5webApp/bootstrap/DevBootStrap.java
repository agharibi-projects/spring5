package com.agharibi.spring5webApp.bootstrap;

import com.agharibi.spring5webApp.model.Author;
import com.agharibi.spring5webApp.model.Book;
import com.agharibi.spring5webApp.model.Publisher;
import com.agharibi.spring5webApp.repositories.AuthorRepository;
import com.agharibi.spring5webApp.repositories.BookRepository;
import com.agharibi.spring5webApp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();;

    }

    private void initData() {

        Publisher publisher1 = new Publisher("Harper Collions", "1200 Main Street, Washington");
        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Drive Desing", "1234", publisher1);
        eric.getBooks().add(book1);

        publisherRepository.save(publisher1);
        authorRepository.save(eric);
        bookRepository.save(book1);


        Publisher publisher2 = new Publisher("Penguins", "4600 First Street, San Diego, CA");
        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("Spring Framework", "5600", publisher2);
        rod.getBooks().add(book2);

        publisherRepository.save(publisher2);
        authorRepository.save(rod);
        bookRepository.save(book2);
    }
}
