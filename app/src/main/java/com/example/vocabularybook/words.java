package com.example.vocabularybook;

import android.provider.BaseColumns;

public class words {

        public static final String TABLE_NAME="words";
        public static final String WORD_ID="id";
        public static final String WORD_NAME="word";//列：单词
        public static final String WORD_MEANING="meaning";//列：单词含义
        public static final String WORD_SAMPLE="sample";//单词示例

    public  int word_id;
    public String word_name;
    public String word_meaning;
    public String word_sample;
}

