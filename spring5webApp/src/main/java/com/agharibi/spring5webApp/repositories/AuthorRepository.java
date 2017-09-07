package com.agharibi.spring5webApp.repositories;

import com.agharibi.spring5webApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    
}
