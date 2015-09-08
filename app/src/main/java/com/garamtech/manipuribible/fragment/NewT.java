package com.garamtech.manipuribible.fragment;
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

/**
 * Created by Ramya on 05-09-2015.
 */
public class NewT extends Fragment {
    private static String tag = "NewT";
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.newt,container,false);

        String[] newTestamentBooks = getResources().getStringArray(R.array.thah_books);

        ListView newTestamentList = (ListView) v.findViewById(R.id.new_testament_booklist);


        Log.i(tag, "newTestamentList = " + newTestamentList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(container.getContext(),
                android.R.layout.simple_list_item_1,
                newTestamentBooks);

        newTestamentList.setAdapter(arrayAdapter);
        return v;
    }
}
