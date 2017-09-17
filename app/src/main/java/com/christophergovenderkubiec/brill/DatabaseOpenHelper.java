package com.christophergovenderkubiec.brill;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by predator on 13/09/2017.
 */


public class DatabaseOpenHelper extends SQLiteOpenHelper {
    final static String TABLE_NAME = "brill_idea";
    final static String IDEA = "idea";
    final static String LOCATION = "location";
    final static String ID = "id";
    long lastInsertId;

    // Create table
    final private static String CREATE_CMD =

        "CREATE TABLE " + TABLE_NAME + "(" + ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + IDEA + " TEXT NOT NULL, "
                + LOCATION + " TEXT )";

    final private static Integer VERSION = 1;
    final private Context mContext;

    public DatabaseOpenHelper(Context context) {
        super(context, TABLE_NAME, null, VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Add idea
    public boolean addIdea(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(IDEA, item);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            lastInsertId = result;
            return true;
        }
    }


    // Get all ideas to populate list view
    public Cursor getIdeas() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    // Count ideas to populate Profileactivity text field
    public int countIdeas() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        int count = data.getCount();
        data.close();
        return count;
    }

    // Add Location
    public boolean addLocation(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LOCATION, item);
        long result = db.update(TABLE_NAME, contentValues, "ID="+lastInsertId, null);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}
