package com.example.vocabularybook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "vocabularydb";//数据库名字
    private final static int DATABASE_VERSION = 1;//数据库版本

    public MyDatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //建表SQL
    private final static String SQL_CREATE_DATABASE = "CREATE TABLE "
            + words.TABLE_NAME
            + " ("
            +words.WORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            +words.WORD_NAME + " TEXT" + ","
            + words.WORD_MEANING + " TEXT" + ","
            + words.WORD_SAMPLE + " TEXT" + " )";

    private final static String SQL_DELETE_DATABASE = "DROP TABLE IF EXISTS " + words.TABLE_NAME;



    @Override    public void onCreate(SQLiteDatabase db) {
        //创建数据库
        db.execSQL(SQL_CREATE_DATABASE);
    }

    @Override    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //当数据库升级时被调用，首先删除旧表，然后调用OnCreate()创建新表
        db.execSQL(SQL_DELETE_DATABASE);
        onCreate(db);
    }
}




//    public static final String CREATE_VOCABULARY ="create table vovabulary ("
//            +"id integer primary key "
//            +"name String"
//            +"yinbiao String"
//            +"lijuyw String"
//            +"lijuzw String";
//
//    private Context mContext;
//    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
//        super(context,name,factory,version);
//        mContext=context;
//    }
//
//    public  void onCreate(SQLiteDatabase db){
//        db.execSQL(CREATE_VOCABULARY);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion) {
//
//    }
