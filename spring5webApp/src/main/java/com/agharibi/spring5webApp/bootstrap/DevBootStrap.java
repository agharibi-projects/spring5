package com.agharibi.spring5webApp.bootstrap;

import com.agharibi.spring5webApp.model.Author;
import com.agharibi.spring5webApp.model.Book;
import com.agharibi.spring5webApp.repositories.AuthorRepository;
import com.agharibi.spring5webApp.repositories.BookRepository;
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


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();;

    }

    private void initData() {

        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Drive Desing", "1234", "Harper Collions");
        eric.getBooks().add(book1);

        authorRepository.save(eric);
        bookRepository.save(book1);

        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("Spring Framework", "5600", "Penguins");
        rod.getBooks().add(book2);

        authorRepository.save(rod);
        bookRepository.save(book2);
    }
}
