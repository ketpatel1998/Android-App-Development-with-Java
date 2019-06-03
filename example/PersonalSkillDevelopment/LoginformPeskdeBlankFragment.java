package com.example.PersonalSkillDevelopment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.SessionRealTimeSharedPreferenceDemo.PreferenceManager;
import com.example.application1.R;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginformPeskdeBlankFragment extends Fragment {


    public LoginformPeskdeBlankFragment() {
        // Required empty public constructor
    }

    EditText etuname;
    EditText etpassword;
    Button btnlogin;
    Context context;

    @Override
    protected void finalize() throws Throwable {

        Intent intent = new Intent(getActivity(), home_peskde.class);
        startActivity(intent);
        getActivity().finish();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loginform_peskde_blank, container, false);

        context = view.getContext();
        etpassword = (EditText) view.findViewById(R.id.etpasswordlogin);
        etuname = (EditText) view.findViewById(R.id.etusernamelogin);
        btnlogin = (Button) view.findViewById(R.id.btloginpeskde);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(etuname.getText().toString().equals(""))
                {
                    etuname.setError("Enter Valid Username");
                }
                else if(etpassword.getText().toString().equals(""))
                {
                    etpassword.setError("Must Enter Password");
                }
                else if((etuname.getText().toString().charAt(0))=='0' || (etuname.getText().toString().charAt(0))=='1' || (etuname.getText().toString().charAt(0))=='2' || (etuname.getText().toString().charAt(0))=='3' || (etuname.getText().toString().charAt(0))=='4' || (etuname.getText().toString().charAt(0))=='5' || (etuname.getText().toString().charAt(0))=='6' || (etuname.getText().toString().charAt(0))=='7' || (etuname.getText().toString().charAt(0))=='8' || (etuname.getText().toString().charAt(0))=='9')
                {
                    etuname.setError("Invalid Username");
                    Toast.makeText(view.getContext(), "Username Should Start with Charactor", Toast.LENGTH_SHORT).show();
                }
                else {
                    String mode = "loginform";
                    String uname = etuname.getText().toString();
                    String pass = etpassword.getText().toString();

                    LoginAsynctaskManager loginasynctaskManager = new LoginAsynctaskManager(context);
                    loginasynctaskManager.execute(mode,uname,pass);


                    PreferenceManagerPeskde preferenceManagerPeskde = new PreferenceManagerPeskde(context);



                }

            }
        });

        return view;
    }

}
