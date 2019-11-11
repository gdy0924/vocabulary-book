package com.example.vocabularybook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class WordRepo {
    private MyDatabaseHelper dbHelper;
    public WordRepo(Context context){
        dbHelper=new MyDatabaseHelper((context));

    }

    public int insert(words word){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(words.WORD_NAME,word.word_name);
        values.put(words.WORD_MEANING,word.word_meaning);
        values.put(words.WORD_SAMPLE,word.word_sample);

        long word_id=db.insert(words.TABLE_NAME,null,values);
        db.close();
        return (int)word_id;
    }

    public void delete(int word_id){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        db.delete(words.TABLE_NAME,words.WORD_ID+"=?",new String[]{String.valueOf(word_id)});
        db.close();
    }

    public void update(words word){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(words.WORD_NAME,word.word_name);
        values.put(words.WORD_MEANING,word.word_meaning);
        values.put(words.WORD_SAMPLE,word.word_sample);

        db.update(words.TABLE_NAME,values,words.WORD_ID+"=?",new String[] { String.valueOf(words.WORD_ID) });
        db.close();
    }
}
