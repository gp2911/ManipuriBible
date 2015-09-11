package com.garamtech.manipuribible.global;

import android.content.Context;
import android.util.Log;

import com.garamtech.manipuribible.R;
import com.garamtech.manipuribible.model.Book;
import com.garamtech.manipuribible.service.api.DeviceFileWriter;
import com.garamtech.manipuribible.service.api.ObjectCreationService;
import com.garamtech.manipuribible.service.impl.DeviceFileWriterImpl;
import com.garamtech.manipuribible.service.impl.ObjectCreationServiceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gp on 9/9/15.
 */
public class Globals {

    private static String tag = "Globals";

    private static DeviceFileWriter deviceFileWriter = null;
    private static ObjectCreationService objectCreationService = null;
    private static List<Book> oldTestamentList = null;
    private static List<Book> newTestamentList = null;

    public static DeviceFileWriter getDeviceFileWriter(){
        if(null == deviceFileWriter)
            deviceFileWriter = new DeviceFileWriterImpl();
        return deviceFileWriter;
    }

    public static ObjectCreationService getObjectCreationService(){
        if(null == objectCreationService)
            objectCreationService = new ObjectCreationServiceImpl();
        return objectCreationService;
    }

    public static List<Book> getOldTestamentBooks(Context context){
        if(null == oldTestamentList)
            initialiseBookLists(context);

        return oldTestamentList;
    }

    public static List<Book> getNewTestamentBooks(Context context){
        if(null == newTestamentList)
            initialiseBookLists(context);

        return newTestamentList;
    }

    private static String processTitle(String title){
        String ret = title.toLowerCase();
        ret = ret.replace(' ', '-');
        Log.i(tag, "Processed title : " + ret);
        return ret;
    }
    private static void initialiseBookLists(Context context){
        //Ensure deviceFileWriter and objectCreationService are not null
        getDeviceFileWriter();
        getObjectCreationService();

        String fileName = deviceFileWriter.copyAssetToDevice(context, "verses.json");
        File jsonFile = new File(fileName);
        List<Book> bookList = objectCreationService.generateBookList(jsonFile);

        List<String> oldTBooks = Arrays.asList(context.getResources().getStringArray(R.array.lui_books));
        List<String> newTBooks = Arrays.asList(context.getResources().getStringArray(R.array.thah_books));

        //convert titles to lower case for easy comparison
        for(int i = 0; i < oldTBooks.size(); i++){
            oldTBooks.set(i, oldTBooks.get(i).toLowerCase());
        }
        for(int i = 0; i < newTBooks.size(); i++){
            newTBooks.set(i, newTBooks.get(i).toLowerCase());
        }

        Log.i(tag, "oldTBooks : " + oldTBooks.toString());
        Log.i(tag, "newTBooks : " + newTBooks.toString());

        //initialise the testaments
        newTestamentList = new ArrayList<>();
        oldTestamentList = new ArrayList<>();

        //populate both the lists
        for(Book book : bookList){
            if(newTBooks.contains(processTitle(book.getName())))
                newTestamentList.add(book);
            else if(oldTBooks.contains(processTitle(book.getName())))
                oldTestamentList.add(book);
            else {
                Log.e(tag, "Book not present in any testament!");
                Log.i(tag, book.getName());
            }
        }

        return;
    }
}
