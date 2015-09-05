package com.garamtech.manipuribible.service.impl;

import com.garamtech.manipuribible.model.Book;
import com.garamtech.manipuribible.service.api.ObjectCreationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gp on 2/9/15.
 */

public class ObjectCreationServiceImpl implements ObjectCreationService {
    @Override
    public List<Book> generateBookList() {
        List<Book> bookList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            bookList = mapper.readValue("res/raw/verses.json", List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!bookList.isEmpty())
            return bookList;
        else
            return null;
    }
}
