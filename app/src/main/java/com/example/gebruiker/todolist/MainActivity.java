package com.example.gebruiker.todolist;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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

        adapter = new TodoAdapter(getApplicationContext(), cursor);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new onItemClickListener());
        listView.setOnItemLongClickListener(new onItemLongClickListener());

    }

    // Step 6:
    public void updateData() {
        adapter.swapCursor( db.selectAll());
    }

    // Step 5:
    public void addItem(View view) {
        editText = (EditText) findViewById(R.id.editText);
        TodoDatabase.getInstance(getApplicationContext()).insert(editText.getText().toString(), 0);
        updateData();
    }

    // Step 7:
    private class onItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int completed, long id) {

            CheckBox cb = (CheckBox) findViewById(R.id.checkBox);



            // test toast
            Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_LONG).show();

            db.update(id, completed);
            updateData();
        }
    }

    // Step 8:
    private class onItemLongClickListener implements AdapterView.OnItemLongClickListener {

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

            Toast.makeText(getApplicationContext(), "tes3t", Toast.LENGTH_LONG).show();

            db.delete(id);
            updateData();
            return false;
        }
    }


}
