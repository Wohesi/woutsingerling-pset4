package com.example.gebruiker.todolist;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

/**
 * Created by Wout on 20-11-2017.
 */

public class TodoAdapter extends ResourceCursorAdapter {

    public  TodoAdapter(Context context, Cursor cursor) {
        super(context, R.layout.row_todo, cursor);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = view.findViewById(R.id.textView);

        //String test = String.valueOf(cursor.getString(cursor.getColumnIndex("title")));
        name.setText(cursor.getString(cursor.getColumnIndex("title")));

        CheckBox complete = view.findViewById(R.id.checkBox);
        complete.setChecked(cursor.getInt(cursor.getColumnIndex("completed")) == 1 );
    }
}

