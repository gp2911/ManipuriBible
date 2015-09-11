package com.garamtech.manipuribible.global.listener;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.garamtech.manipuribible.R;
import com.garamtech.manipuribible.global.Globals;
import com.garamtech.manipuribible.model.Book;

/**
 * Created by gp on 9/9/15.
 */
public class BookTitleClickListener {

    private static OnItemClickListener listener = null;
    private static String tag = "BTCL";
    public static OnItemClickListener getListener(){
        if(null == listener)
            createListener();
        return listener;
    }

    private static void renderText(TextView textView, Book bookToRender){
        textView.append(bookToRender.getName());
    }

    private static void createListener(){
        listener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(tag, "Parent = " + parent.toString());
                Log.i(tag, "View = " + view.toString());
                Log.i(tag, "Position = " + position);
                Log.i(tag, "Id = " + id);
                Log.i(tag, parent.getParent().toString());

                //check if oldTestament or newTestament
                if(parent.getId() == R.id.old_testament_booklist){
                    Log.i(tag, "Need to open old testament.");
                    RelativeLayout layout = (RelativeLayout) parent.getParent();
                    TextView textView = (TextView)layout.findViewById(R.id.old_testament_text);

                    layout.findViewById(R.id.old_testament_booklist).setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.VISIBLE);


                    String[] bookTitles = layout.getResources().getStringArray(R.array.lui_books);
                    String requiredBookTitle =  bookTitles[position];
                    Log.i(tag, requiredBookTitle);
                    Book requiredBook = null;
                    for(Book book : Globals.getOldTestamentBooks(layout.getContext())){
                        if(requiredBookTitle.toLowerCase().equals(book.getName().toLowerCase())) {
                            requiredBook = book;
                            break;
                        }
                    }
                    Log.i(tag, requiredBook.getName());
                    renderText(textView, requiredBook);

                }

                else if(parent.getId() == R.id.new_testament_booklist){
                    Log.i(tag, "Need to open new testament.");
                    RelativeLayout layout = (RelativeLayout) parent.getParent();
                    TextView textView = (TextView)layout.findViewById(R.id.new_testament_text);

                    layout.findViewById(R.id.new_testament_booklist).setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.VISIBLE);

                    String[] bookTitles = layout.getResources().getStringArray(R.array.thah_books);
                    String requiredBookTitle =  bookTitles[position];
                    Log.i(tag, requiredBookTitle);
                    Book requiredBook = null;
                    for(Book book : Globals.getNewTestamentBooks(layout.getContext())){
                        if(requiredBookTitle.toLowerCase().equals(book.getName().toLowerCase())) {
                            requiredBook = book;
                            break;
                        }
                    }
                    Log.i(tag, requiredBook.getName());
                    renderText(textView, requiredBook);
                }
            }
        };
    }
}
