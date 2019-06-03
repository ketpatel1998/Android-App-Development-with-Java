package com.example.SearchViewDemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.application1.R;

public class SearchViewDemo1 extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView searchViewDemo1;
    ListView listView;
    String[] data = {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_demo1);

        listView = (ListView) findViewById(R.id.listview1);
        searchViewDemo1 = (SearchView) findViewById(R.id.searchview1);

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,data);
        listView.setAdapter(arrayAdapter);
        searchViewDemo1.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        String text = newText;
        arrayAdapter.getFilter().filter(text);

        return false;
    }
}
