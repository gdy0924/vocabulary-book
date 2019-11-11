package com.example.vocabularybook;


public class WordList {
    private String name;
    private String meaning;
    private String sample;
    private int id;

    public WordList(){

    }

    public WordList(int id,String name,String meaning,String sample){
        this.id =id;
        this.name=name;
        this.meaning=meaning;
        this.sample=sample;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String getMeaning(){
        return meaning;
    }

    public String getSample(){
        return sample;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

}
