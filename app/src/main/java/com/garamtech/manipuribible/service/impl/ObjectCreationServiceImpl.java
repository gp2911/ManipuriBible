package com.garamtech.manipuribible.service.impl;

import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.garamtech.manipuribible.model.Book;
import com.garamtech.manipuribible.service.api.ObjectCreationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by gp on 2/9/15.
 */

public class ObjectCreationServiceImpl implements ObjectCreationService {

    private static String tag = "OCS";
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<Book> generateBookList(File file) {
        List<Book> bookList = new ArrayList<>();


        try {
            List list = mapper.readValue(file, List.class);
            for(Object object : list){
                Log.i(tag, ((LinkedHashMap) object).toString());
                bookList.add(mapper.convertValue(object, Book.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d(tag + ".generateBookList", bookList.toString());

        if(!bookList.isEmpty())
            return bookList;
        else
            return null;
    }

    @Override
    public Book convertToBook(LinkedHashMap map) {
        return mapper.convertValue(map, Book.class);
    }
}
