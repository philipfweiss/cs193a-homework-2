package com.example.philipfweiss.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
    ArrayList<String> toDoItems = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView todolist = (ListView) findViewById(R.id.todolist);
        todolist.setOnItemLongClickListener(this);
        // Create array list that can store todo items



    }
    public void addContent (View view){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                toDoItems
        );
        TextView editText = (TextView) findViewById(R.id.editText);
        String content = editText.getText().toString();
        toDoItems.add(content);
        adapter.notifyDataSetChanged();
        ListView list = (ListView) findViewById(R.id.todolist);
        list.setAdapter(adapter);
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int index, long id) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                toDoItems
        );
        TextView editText = (TextView) findViewById(R.id.editText);
        String content = editText.getText().toString();
        toDoItems.remove(index);
        adapter.notifyDataSetChanged();
        ListView list = (ListView) findViewById(R.id.todolist);
        list.setAdapter(adapter);
        return false;
    }
}
