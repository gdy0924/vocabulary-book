package com.example.vocabularybook;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Map;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.UserDictionary;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DB_operator {

    private MyDatabaseHelper dbHelper;
    private String TAG = "MainActivity";
    ArrayList<Map<String, String>> ConvertCursor2WordList;

    public void insert(Words word){

        //创建SQLiteDatabase的对象
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //创建ContentValues对象，又来添加数据
        ContentValues values = new ContentValues();
        values.put("word",word.getWord());
        values.put("meaning", word.getMeaning());
        values.put("example", word.getExample());
        //插入数据（param1 :表名，param2：在未指定的数据的情况下赋值为空，params3：值）
        db.insert("words",null,values);

    }
    public void delete(String word){
        SQLiteDatabase dbDelete =dbHelper.getWritableDatabase();
        dbDelete.delete("words","word = ?",new String[] {word});


    }
    public void update(Words oldWord, Words newWord){
        SQLiteDatabase dbUpdate =dbHelper.getWritableDatabase();
        ContentValues values1 = new ContentValues();
        values1.put("meaning",newWord.getMeaning());
        dbUpdate.update("words",values1,"meaning = ?",new String[]{newWord.getMeaning()});
        values1.put("example",newWord.getExample());
        dbUpdate.update("words",values1,"example = ?",new String[]{newWord.getExample()});
    }
    public void query(String word){
        //创建SQLiteDatabase对象
        SQLiteDatabase db1 = dbHelper.getWritableDatabase();
        //使用游标，游历表中所有数据（params1：表名，params2：指定查询的列名，param3：指定where约束条件；params4：占位符具体值；下面的参数与分组，排序有关）
        Cursor cursor = db1.query("word",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                //取数据
                String name = cursor.getString(cursor.getColumnIndex("name"));
                Log.e(TAG, "onClick: "+name);
            }while (cursor.moveToNext());
        }
        cursor.close();

    }


    public ArrayList<Map<String, String>> SearchUseSql(String strWordSearch) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String sql = "select * from words where word like ? order by word desc";
        Cursor c = db.rawQuery(sql, new String[]{"%" + strWordSearch + "%"});

        return ConvertCursor2WordList;
    }

    public void UpdateUseSql(String strId, String strWord, String strMeaning, String strSample) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "update words set word=?,meaning=?,sample=? where _id=?";
        db.execSQL(sql, new String[]{strWord,strMeaning, strSample, strId});
    }

    public void DeleteUseSql(String strId) {
        String sql = "delete from words where _id='" + strId + "'";

        //Gets the data repository in write mode*/
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.execSQL(sql);
    }

    public void InsertUserSql(String strWord, String strMeaning, String strSample) {
        String sql = "insert into  words(_id,word,meaning,sample) values(?,?,?,?)";

        //Gets the data repository in write mode*/
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL(sql, new String[]{strWord, strMeaning, strSample});
    }
}
