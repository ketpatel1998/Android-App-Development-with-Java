package com.example.PersonalSkillDevelopment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.application1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class registerFormPeskdeBlankFragment extends Fragment {

    EditText etname;
    EditText etuname;
    EditText etpassword;
    EditText etphone;
    EditText etemail;
    Button btnregister;
    Context context;

    SharedPreferences msharedpreSharedPreferences1;
    SharedPreferences.Editor meditEditor1;
    public registerFormPeskdeBlankFragment() {
        // Required empty public constructor
    }


    @Override
    protected void finalize() throws Throwable {


        super.finalize();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_register_form_peskde_blank, container, false);


        context = getContext();
        etname = (EditText) view.findViewById(R.id.etname1);
        etemail = (EditText) view.findViewById(R.id.etemail1);
        etuname = (EditText) view.findViewById(R.id.etuname1);
        etpassword = (EditText) view.findViewById(R.id.etpassword1);
        etphone = (EditText) view.findViewById(R.id.etphone1);

        btnregister = (Button) view.findViewById(R.id.btnregister1);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etname.getText().toString().equals(""))
                {
                    etname.setError("Enter Name First!");
                }
                else if(etuname.getText().toString().equals(""))
                {
                    etuname.setError("Enter Valid Username");
                }
                else if(etemail.getText().toString().equals(""))
                {
                    etemail.setError("Enter Your Email Here");
                }
                else if(etphone.getText().toString().equals(""))
                {
                    etphone.setError("Mobile Should be 10 digit No");
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
                else if((etphone.getText().toString().length())!=10)
                {
                    etphone.setError("Invalid Phone Number");
                    Toast.makeText(view.getContext(), "Phone Should be In 10 Digit", Toast.LENGTH_SHORT).show();
                }
                else{

                    String mode = "register";
                    String name = etname.getText().toString();
                    String email = etemail.getText().toString();
                    String phone = etphone.getText().toString();
                    String username = etuname.getText().toString();
                    String password = etpassword.getText().toString();

                    PreferenceManagerPeskde preferenceManagerPeskde = new PreferenceManagerPeskde(getContext());
                    preferenceManagerPeskde.setRegisterInfo(name, username, email, phone, password);

                    AsynctaskManager asynctaskManager = new AsynctaskManager(context);
                    asynctaskManager.execute(mode,name,email,phone,username,password);
                    //String userid = asynctaskManager.doInBackground(mode,name,email,phone,username,password);




                   // String userid = asynctaskManager.getServerresponse();


                        ///int id = Integer.parseInt(userid);

//                        msharedpreSharedPreferences1 = getContext().getSharedPreferences("PESKDE", Context.MODE_PRIVATE);
//                        meditEditor1 = msharedpreSharedPreferences1.edit();
//                        meditEditor1.putString("USERID",userid);
//                        meditEditor1.putString("NAME",name);
//                        meditEditor1.putString("EMAIL",email);
//                        meditEditor1.putString("PHONE",phone);
//                        meditEditor1.putString("USERNAME",username);
//                        meditEditor1.putString("PASSWORD",password);
//                        meditEditor1.commit();

//                    }
//                    catch (Exception e)
//                    {
//                        Toast.makeText(getContext(), "Your Phone Number Is Already Has Been Registered", Toast.LENGTH_SHORT).show();
//                    }

                }
            }
        });


        return view;
    }

}
