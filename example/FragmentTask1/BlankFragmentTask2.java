package com.example.FragmentTask1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.application1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragmentTask2 extends Fragment {


    public BlankFragmentTask2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_fragment_task2, container, false);
    }

}
