package com.example.gebruiker.todolist;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoDatabase db = todoDatabase.getInstance(getApplicationContext());
        Cursor cursor = db.selectAll();

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new TodoAdapter(getApplicationContext(), cursor));

    }

    public void addItem(View view) {
        button = (Button) findViewById(R.id.button);
        todoDatabase.getInstance(getApplicationContext()).insert("title", 0);
    }

//    private void updateData(View view) {
//
//        private TodoAdapter adapter;
//    }

}
