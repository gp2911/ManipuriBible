package com.garamtech.manipuribible.service.api;

import com.garamtech.manipuribible.model.Book;

import java.util.List;

/**
 * Created by gp on 2/9/15.
 */
public interface ObjectCreationService {

    /**
     * Generates list of books by reading verses.json
     * @return List containing all books
     */
    public List<Book> generateBookList();
}
