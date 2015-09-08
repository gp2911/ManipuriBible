package com.garamtech.manipuribible.service.impl;

import android.util.Log;

import com.garamtech.manipuribible.model.Book;
import com.garamtech.manipuribible.service.api.ObjectCreationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gp on 2/9/15.
 */

public class ObjectCreationServiceImpl implements ObjectCreationService {

    private static String tag = "OCS";

    @Override
    public List<Book> generateBookList(File file) {
        List<Book> bookList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            bookList = mapper.readValue(file, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d(tag + ".generateBookList", bookList.toString());

        if(!bookList.isEmpty())
            return bookList;
        else
            return null;
    }
}
