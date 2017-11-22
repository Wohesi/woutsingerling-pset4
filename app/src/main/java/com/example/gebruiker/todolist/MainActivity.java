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

    // Correct position?
    private void updateData(View view) {
        adapter.swapCursor(db.selectAll());
    }


    public void addItem(View view) {
        // A possible way to add text?
        // editText = (EditText) findViewById(R.id.editText);
        // TodoDatabase.getInstance(getApplicationContext()).insert(editText,0);

        TodoDatabase.getInstance(getApplicationContext()).insert("title", 0);
        // ? TodoDatabase.updateData();
    }

    private class onItemClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // stuff to do

        }
    }


}
