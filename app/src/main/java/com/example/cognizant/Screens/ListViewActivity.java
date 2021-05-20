package com.example.cognizant.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.cognizant.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView =  (ListView)findViewById(R.id.listview);

        ArrayList<String> technologyStack = new ArrayList<>();
        technologyStack.add("FlutterSDK");
        technologyStack.add("Java");
        technologyStack.add("Vanilla JavaScript");
        technologyStack.add("React.js");
        technologyStack.add("Express.js");
        technologyStack.add("Node.js");
        technologyStack.add("Firebase");
        technologyStack.add("PostgreSQL");
        technologyStack.add("mySQL");
        technologyStack.add("HTML/CSS");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, technologyStack);

        listView.setAdapter(arrayAdapter);



    }
}