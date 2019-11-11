package com.example.vocabularybook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    private List<WordList> wordlist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.land);
        }else {
            setContentView(R.layout.activity_main);
            initWords();
//            WordAdapter adapter = new WordAdapter(MainActivity.this, R.layout.word_item, wordlist);
//            ListView listView = (ListView) findViewById(R.id.list_view);
//            listView.setAdapter(adapter);
            listView = (ListView) findViewById(R.id.list_view);
            myListItems = new ArrayList<WordList>();
            adapter = new WordAdapter(MainActivity.this);
            adapter.setListItems(myListItems);
            listView.setAdapter(adapter);
        }

        //创建SQLiteOpenHelper对象，注意第一次运行时，此时数据库并没有被创建
        //SQLiteOpenHelper vDbHelper = new MyDatabaseHelper(MainActivity.this);


    }

    private ListView listView;
    private String[] word_name = { "apple", "banana"};
    private String[] word_meaning = { "苹果", "香蕉" };
    private int[] word_id = { 1, 2 };
    private  String[] word_sample={"hhh","bbb"};

    private List<WordList> myListItems=new ArrayList<>();
    private WordAdapter adapter;

    public void initWords() {
        for (int i = 0; i < word_name.length; i++) {
            WordList wl = new WordList();
            wl.setId(word_id[i]);
            wl.setName(word_name[i]);
            wl.setMeaning(word_meaning[i]);
            wl.setSample(word_sample[i]);
            myListItems.add(wl);
        }
    }




//    protected void onDestroy() {
//        super.onDestroy();
//        vDbHelper.close();
//    }

}
