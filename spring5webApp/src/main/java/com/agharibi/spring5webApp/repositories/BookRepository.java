package com.agharibi.spring5webApp.repositories;

import com.agharibi.spring5webApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
}
