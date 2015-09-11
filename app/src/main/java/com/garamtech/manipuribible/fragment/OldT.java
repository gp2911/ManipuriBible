package com.garamtech.manipuribible.fragment;

/**
 * Created by Ramya on 05-09-2015.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.garamtech.manipuribible.R;
import com.garamtech.manipuribible.global.listener.BookTitleClickListener;


public class OldT extends Fragment {

    private static String tag = "OldT";
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v =inflater.inflate(R.layout.oldt, container, false);

        String[] oldTestamentBooks = getResources().getStringArray(R.array.lui_books);
        TextView oldTestamentText = (TextView) v.findViewById(R.id.old_testament_text);
        ListView oldTestamentList = (ListView) v.findViewById(R.id.old_testament_booklist);

        //Hide the text view and bring the listView forward
        oldTestamentList.bringToFront();
        oldTestamentText.setVisibility(View.INVISIBLE);

        Log.i(tag, "oldTestamentList = " + oldTestamentList);

        //Populate the list view using oldTestamentBooks
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(container.getContext(),
                android.R.layout.simple_list_item_1,
                oldTestamentBooks);
        oldTestamentList.setAdapter(arrayAdapter);

        oldTestamentList.setOnItemClickListener(BookTitleClickListener.getListener());
        return v;
    }

}
