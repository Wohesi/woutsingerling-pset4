package com.example.gebruiker.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wout on 20-11-2017.
 */

public class TodoDatabase extends SQLiteOpenHelper {

    private TodoDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static TodoDatabase instance;


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table todos (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, completed INTEGER);");
        sqLiteDatabase.execSQL("insert into todos(title, completed) values('testTitle1', 0)");
        sqLiteDatabase.execSQL("insert into todos(title, completed)values('testTitle2', 1)");
        sqLiteDatabase.execSQL("insert into todos(title, completed)values('testTitle3', 1)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP IF TABLE EXISTS" + "todos");
        onCreate(sqLiteDatabase);

    }

    public static TodoDatabase getInstance(Context context) {

        if (instance != null ) {
            return instance;
        } else {
            instance = new TodoDatabase(context, "name", null, 1);
            return instance;
        }
    }

    public Cursor selectAll() {
        return getWritableDatabase().rawQuery("SELECT * FROM todos", null);
    }


    public void insert(String title, int completed) {
        // Get connection
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        // put values
        cv.put(title, completed);
        db.insert("todos", "null", cv);
    }

}