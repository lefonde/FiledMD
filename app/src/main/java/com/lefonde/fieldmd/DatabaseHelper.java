package com.lefonde.fieldmd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "PERSONID";
    public static final String COL_3 = "FIRSTNAME";
    public static final String COL_4 = "LASTNAME";
    public static final String COL_5 = "AGE";
    public static final String COL_6 = "TIMEOFINJURY";
    public static final String COL_7 = "TIMEOFADMISSION";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PERSONID TEXT," +
                "FIRSTNAME TEXT," +
                "LASTNAME TEXT," +
                "AGE TEXT," +
                "TIMEOFINJURY TEXT," +
                "TIMEOFADMISSION TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String personID,
                              String firstName,
                              String lastName,
                              String age,
                              String timeOfInjury,
                              String TimeOfAdmission) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,personID);
        contentValues.put(COL_3,firstName);
        contentValues.put(COL_4,lastName);
        contentValues.put(COL_5,age);
        contentValues.put(COL_6,timeOfInjury);
        contentValues.put(COL_7,TimeOfAdmission);

        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,
                              String personID,
                              String firstName,
                              String lastName,
                              String age,
                              String timeOfInjury,
                              String TimeOfAdmission) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,personID);
        contentValues.put(COL_3,firstName);
        contentValues.put(COL_4,lastName);
        contentValues.put(COL_5,age);
        contentValues.put(COL_6,timeOfInjury);
        contentValues.put(COL_7,TimeOfAdmission);

        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}