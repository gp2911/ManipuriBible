package com.garamtech.manipuribible.fragment;

/**
 * Created by Ramya on 05-09-2015.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.garamtech.manipuribible.R;


public class oldt extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.oldt,container,false);
        return v;
    }
}
