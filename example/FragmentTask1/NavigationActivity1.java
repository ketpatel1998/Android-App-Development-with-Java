package com.example.FragmentTask1;

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

import com.example.FragmentExample.BlankFragment1;
import com.example.FragmentExample.BlankFragment2;
import com.example.application1.R;

public class NavigationActivity1 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    BlankFragmentTask1 blankFragmentTask1;
    BlankFragmentTask2 blankFragmentTask2;
    BlankFragmentTask3 blankFragmentTask3;
    BlankFragment1 blankFragment1;
    BlankFragment2 blankFragment2;
    FragmentManager manager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        manager = getSupportFragmentManager();

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
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            // Handle the camera action
            blankFragmentTask1 = new BlankFragmentTask1();
            transaction = manager.beginTransaction();
            transaction.add(R.id.contentframe,blankFragmentTask1,"C");
            transaction.addToBackStack("nav_profile");
            transaction.commit();



        } else if (id == R.id.nav_login) {


            blankFragmentTask2 = new BlankFragmentTask2();
            transaction = manager.beginTransaction();
            transaction.replace(R.id.contentframe,blankFragmentTask2,"D");
            transaction.addToBackStack("nav_login");
            transaction.commit();

        } else if (id == R.id.nav_profile2) {


            blankFragmentTask3 = new BlankFragmentTask3();
            transaction = manager.beginTransaction();
            transaction.replace(R.id.contentframe,blankFragmentTask3,"G");
            transaction.addToBackStack("nav_profile2");
            transaction.commit();

        }
        else if (id == R.id.nav_slideshow) {

            blankFragment2 = new BlankFragment2();
            transaction = manager.beginTransaction();
            transaction.replace(R.id.contentframe,blankFragment2,"E");
            transaction.addToBackStack("nav_slideshow");
            transaction.commit();

        } else if (id == R.id.nav_manage) {
            blankFragment1 = new BlankFragment1();
            transaction = manager.beginTransaction();
            transaction.replace(R.id.contentframe,blankFragment1,"F");
            transaction.addToBackStack("nav_manage");
            transaction.commit();


        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
