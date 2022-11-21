package com.example.sqliteauthenticationapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DBNAME="Login.db";

    public DbHelper( Context context) {
        super(context, "Login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase mydb) {

        mydb.execSQL("CREATE Table Users(Email TEXT primary key, Password TEXT, FullName TEXT)" );
        mydb.execSQL("create table Notes(Title TEXT primary key, Description Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int i, int i1) {
        mydb.execSQL("drop Table if exists Users");
        mydb.execSQL("drop Table if exists Notes");
    }

    public Boolean insertData(String Email, String Password, String FullName){
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Email", Email);
        contentValues.put("Password", Password);
        contentValues.put("FullName", FullName);
        long results = mydb.insert("Users", null, contentValues);
        if(results==-1) return  false;
        else
            return true;


    }
    public Boolean checkEmail(String Email){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from Users where Email = ?", new String[]{Email});
        if(cursor.getCount()>0)
        return true;
        else
            return false;
    }
    public  Boolean CheckEmailPassword(String Email, String Password){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from Users where Email = ? And Password = ?",new String[]{Email, Password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean insertNotes(String Title, String Description){
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Title", Title);
        contentValues.put("Description", Description);
        long results = mydb.insert("Users", null, contentValues);
        if(results==-1) return  false;
        else
            return true;


    }
    public Boolean checkTitle(String Title){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from Notes where Title = ?", new String[]{Title});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public  Boolean CheckTitleDescription(String Title, String Description){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from Notes where Title = ? And Description = ?",new String[]{Title, Description});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
