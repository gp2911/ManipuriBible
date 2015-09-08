package com.garamtech.manipuribible.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.garamtech.manipuribible.R;

/**
 * Created by Ramya on 05-09-2015.
 */
public class newt extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.newt,container,false);
        return v;
    }
}
