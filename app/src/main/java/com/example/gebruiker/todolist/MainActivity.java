package com.example.gebruiker.todolist;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        todoDatabase db = todoDatabase.getInstance(getApplicationContext());
        Cursor cursor = db.selectAll();

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new TodoAdapter(getApplicationContext(), cursor));




    }
}
