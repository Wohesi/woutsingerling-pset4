package com.example.gebruiker.todolist;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    // Add private instance variables:
    private TodoAdapter adapter;
    private TodoDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = TodoDatabase.getInstance(getApplicationContext());
        Cursor cursor = db.selectAll();

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new TodoAdapter(getApplicationContext(), cursor));



    }

    // Step 6:
    // private method called updateData

    // Correct position?
    private void updateData(View view) {

        // swap cursor method on the adaptor.
        adapter.swapCursor(

                // call select all on the database.
                db.selectAll()
        );
    }


    // Step 5:
    // Linking the button int he main activity method addItem
    public void addItem(View view) {
        // A possible way to add text?
        // editText = (EditText) findViewById(R.id.editText);
        // TodoDatabase.getInstance(getApplicationContext()).insert(editText,0);

        // getting the database object and calling insert
        TodoDatabase.getInstance(getApplicationContext()).insert("title", 0);
        // ? TodoDatabase.updateData();
    }

    // Step 7:
    // private class onItemClickListener
    private class onItemClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // stuff to do

        }
    }


}
