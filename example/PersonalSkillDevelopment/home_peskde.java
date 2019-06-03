package com.example.PersonalSkillDevelopment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.application1.R;

public class home_peskde extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    registerFormPeskdeBlankFragment registerformBlankFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    HomePeskdeBlankFragment homePeskdeBlankFragment;
    LoginformPeskdeBlankFragment loginformPeskdeBlankFragment;

    Button btnhomeregister;
    TextView tvusername;
    TextView tvuserhomecontent;
    MenuItem loginitem;
    MenuItem registeritem;
    MenuItem logoutitem;
    MenuItem navslideshowitem;
    PreferenceManagerPeskde preferenceManagerPeskde;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_peskde);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        fragmentManager = getSupportFragmentManager();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);





            setHomeFragement();




    }

    public void setHomeFragement()
    {
        btnhomeregister = findViewById(R.id.btnhomeregister);
        tvusername = findViewById(R.id.tvusername);
        tvuserhomecontent = findViewById(R.id.tvuserhomecontent);

        preferenceManagerPeskde = new PreferenceManagerPeskde(this);
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
                //fragmentTransaction.addToBackStack("registerfromhome");
                //fragmentTransaction.disallowAddToBackStack();
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.home_peskde, menu);

        registeritem =  menu.findItem(R.id.action_register);
        loginitem =  menu.findItem(R.id.action_login);
        logoutitem =  menu.findItem(R.id.action_logout);
        navslideshowitem = menu.findItem(R.id.nav_slideshow);
        preferenceManagerPeskde = new PreferenceManagerPeskde(this);
        String login = preferenceManagerPeskde.getLoginSharedPrefrence();
        if(login.equals("SET"))
        {
            registeritem.setVisible(false);
            loginitem.setVisible(false);
            logoutitem.setVisible(true);
//            Intent intent = new Intent(this,home_peskde.class);
//            startActivity(intent);
//            finish();


        }
        else
        {

            registeritem.setVisible(true);
            loginitem.setVisible(true);
            logoutitem.setVisible(false);

        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_login) {

            loginformPeskdeBlankFragment = new LoginformPeskdeBlankFragment();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.registerformframe, loginformPeskdeBlankFragment, "D");
//                fragmentTransaction.addToBackStack("register");
            //fragmentTransaction.disallowAddToBackStack();
            fragmentTransaction.commit();



            return true;
        }
        if (id == R.id.action_register) {





                registerformBlankFragment = new registerFormPeskdeBlankFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.registerformframe, registerformBlankFragment, "A");
//                fragmentTransaction.addToBackStack("register");
                //fragmentTransaction.disallowAddToBackStack();
                fragmentTransaction.commit();



            return true;
        }
        if (id == R.id.action_logout) {



            preferenceManagerPeskde = new PreferenceManagerPeskde(this);
            preferenceManagerPeskde.setLogoutSharedPreference();

            Intent intent = new Intent(this,home_peskde.class);
            startActivity(intent);
            finish();


            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_homepage) {

                homePeskdeBlankFragment = new HomePeskdeBlankFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.registerformframe, homePeskdeBlankFragment, "B");
                //fragmentTransaction.addToBackStack("home");
                fragmentTransaction.commit();



            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            Intent intent = new Intent(this,registerFormPeskde.class);
            startActivity(intent);

        } else if (id == R.id.nav_scincequiz) {

            preferenceManagerPeskde = new PreferenceManagerPeskde(this);
            String login = preferenceManagerPeskde.getLoginSharedPrefrence();
            if(login.equals("SET"))
            {


                Intent intent = new Intent(this,ScinceKnowledgeActivity.class);
                startActivity(intent);

            }
            else
            {
                Intent intent = new Intent(this,home_peskde.class);
                startActivity(intent);
            }



        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
