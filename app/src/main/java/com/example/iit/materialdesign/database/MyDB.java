package com.example.iit.materialdesign.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.iit.materialdesign.model.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IIT on 4/8/2015.
 */
public class MyDB {
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.COLUMN_NAME, MySQLiteHelper.COLUMN_FLUX };
    private String search;
    Cursor cursor = null;
    public MyDB(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Comment createComment(String name, String flux) {

        Log.e("MyDB", name + " "+flux);
        ContentValues values = new ContentValues();
//        values.put(MySQLiteHelper.COLUMN_ID, i);
        values.put(MySQLiteHelper.COLUMN_NAME, name);
        values.put(MySQLiteHelper.COLUMN_FLUX, flux);
        long insertId = database.insert(MySQLiteHelper.TABLE_FABOURITE, null,
                values);
//        Log
//        String insertId
        Cursor cursor = database.query(MySQLiteHelper.TABLE_FABOURITE,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Comment newComment = cursorToComment(cursor);
        cursor.close();
        return newComment;
    }

    public void deleteComment(String starName) {
        database.delete(MySQLiteHelper.TABLE_FABOURITE, MySQLiteHelper.COLUMN_NAME
                + " = " + starName, null);
    }

    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<Comment>();

        cursor = database.query(MySQLiteHelper.TABLE_FABOURITE,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Comment comment = cursorToComment(cursor);
            comments.add(comment);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return comments;
    }

    private Comment cursorToComment(Cursor cursor) {
        Comment comment = new Comment();
//        comment.setId(cursor.getLong(0));
        comment.setStarName(cursor.getString(0));
        comment.setStarFlux(cursor.getString(1));
        Log.e("CursortoComment", cursor.getString(1));
        return comment;
    }

//    public Comment searchData(int id){
//        search = "SELECT * FROM "+MySQLiteHelper.TABLE_FABOURITE +" WHERE " + MySQLiteHelper.COLUMN_ID + " = "
//        Cursor cursor = database.query(MySQLiteHelper.TABLE_FABOURITE, MySQLiteHelper.COLUMN_ID
//                + " = " + id, null);
//    }
}
