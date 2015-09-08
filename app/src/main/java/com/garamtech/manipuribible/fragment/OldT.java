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

import com.garamtech.manipuribible.R;


public class OldT extends Fragment {

    private static String tag = "OldT";
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v =inflater.inflate(R.layout.oldt,container,false);
        String[] oldTestamentBooks = getResources().getStringArray(R.array.lui_books);

        ListView oldTestamentList = (ListView) v.findViewById(R.id.old_testament_booklist);


        Log.i(tag, "oldTestamentList = " + oldTestamentList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(container.getContext(),
                android.R.layout.simple_list_item_1,
                oldTestamentBooks);

        oldTestamentList.setAdapter(arrayAdapter);
        return v;
    }

}
