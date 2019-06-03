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
public class BlankFragmentTask3 extends Fragment {


    public BlankFragmentTask3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_fragment_task3, container, false);
    }

}
