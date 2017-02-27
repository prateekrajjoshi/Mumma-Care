package com.example.user.mumma_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by User on 11/23/2015.
 */
public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME= "MummaCareDatabase.DB";
    private static final int DATABASE_VERSION= 1;
    private static final String CREATE_QUERY=
            "CREATE TABLE "+ UserInformation.NewUserInfo.TABLE_NAME+"("+ UserInformation.NewUserInfo.USER_NAME+" TEXT,"+
                    UserInformation.NewUserInfo.USER_AGE+" TEXT,"+
                    UserInformation.NewUserInfo.USER_MOBILE+" TEXT,"+
                    UserInformation.NewUserInfo.USER_HUSBAND+" TEXT,"+
                    UserInformation.NewUserInfo.USER_HUSBAND_MOBILE+" TEXT,"+
                    UserInformation.NewUserInfo.USER_ADDRESS+" TEXT,"+
                    UserInformation.NewUserInfo.USER_PREGNANCY_DATE+" TEXT,"+
                    UserInformation.NewUserInfo.USER_EXPECTED+" TEXT,"+
                    UserInformation.NewUserInfo.USER_DISEASES+" TEXT);";

    public UserDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "Database Created");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Table Created");
    }

    public void addInformations(String name, String age, String mobile,String husband, String h_mobile,String address, String pregnancy,String expected,String diseases,  SQLiteDatabase db)
    {
        ContentValues contentValues= new ContentValues();
        contentValues.put(UserInformation.NewUserInfo.USER_NAME,name);
        contentValues.put(UserInformation.NewUserInfo.USER_AGE,age);
        contentValues.put(UserInformation.NewUserInfo.USER_MOBILE,mobile);
        contentValues.put(UserInformation.NewUserInfo.USER_HUSBAND,husband);
        contentValues.put(UserInformation.NewUserInfo.USER_HUSBAND_MOBILE, h_mobile);
        contentValues.put(UserInformation.NewUserInfo.USER_ADDRESS,address);
        contentValues.put(UserInformation.NewUserInfo.USER_PREGNANCY_DATE, pregnancy);
        contentValues.put(UserInformation.NewUserInfo.USER_EXPECTED,expected);
        contentValues.put(UserInformation.NewUserInfo.USER_DISEASES,diseases);
        db.insert(UserInformation.NewUserInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "One Row Inserted..");
    }


    public Cursor getInformations (String user_name,SQLiteDatabase sqLiteDatabase)
    {
        String[] projections= {UserInformation.NewUserInfo.USER_NAME, UserInformation.NewUserInfo.USER_MOBILE, UserInformation.NewUserInfo.USER_ADDRESS, UserInformation.NewUserInfo.USER_PREGNANCY_DATE, UserInformation.NewUserInfo.USER_EXPECTED, UserInformation.NewUserInfo.USER_DISEASES};
        String selection= UserInformation.NewUserInfo.USER_NAME+" LIKE ?";
        String[] selection_args= {user_name};
        Cursor cursor= sqLiteDatabase.query(UserInformation.NewUserInfo.TABLE_NAME, projections, selection, selection_args,null,null,null);
        return cursor;

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}