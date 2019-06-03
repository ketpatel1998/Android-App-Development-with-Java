package com.example.PersonalSkillDevelopment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.application1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePeskdeBlankFragment extends Fragment {


    public HomePeskdeBlankFragment() {
        // Required empty public constructor
    }
    Button btnhomeregister;
    TextView tvusername;
    TextView tvuserhomecontent;
    registerFormPeskdeBlankFragment registerformBlankFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    PreferenceManagerPeskde preferenceManagerPeskde;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home_peskde_blank, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();
        btnhomeregister = view.findViewById(R.id.btnhomeregister);
        tvusername = view.findViewById(R.id.tvusername);
        tvuserhomecontent = view.findViewById(R.id.tvuserhomecontent);

        preferenceManagerPeskde = new PreferenceManagerPeskde(getContext());
        String login = preferenceManagerPeskde.getLoginSharedPrefrence();

        if(login.equals("SET"))
        {
            String uname2 = preferenceManagerPeskde.getUsernameSharePrefrence();
            tvusername.setText(uname2);
            tvuserhomecontent.setText("Hello User, In Personal Skill Development Program we are going to give you some skill development exersice like knowledge test, listening Test and so on. So Enjoy yourself !");
            btnhomeregister.setVisibility(View.INVISIBLE);
        }


        btnhomeregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerformBlankFragment = new registerFormPeskdeBlankFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.registerformframe,registerformBlankFragment,"C");
                fragmentTransaction.addToBackStack("registerfromhome");
                fragmentTransaction.commit();
            }
        });


        return view;
    }

}
