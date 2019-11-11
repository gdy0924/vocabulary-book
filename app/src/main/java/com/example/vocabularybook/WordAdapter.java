package com.example.vocabularybook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends BaseAdapter {
//    private int resourceId;
//    public WordAdapter(Context context, int textViewResourceId, List<WordList> object){
//        super(context,textViewResourceId,object);
//        resourceId=textViewResourceId;
//    }
//
//    public View getView(int position, View convertView, ViewGroup parent){
//        WordList word=getItem(position);
//        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
//        TextView name=(TextView)view.findViewById(R.id.word_name);
//        TextView meaning=(TextView)view.findViewById(R.id.word_meaning);
//        name.setText(word.getName());
//        meaning.setText(word.getMeaning());
//        return view;
//    }



    private List<WordList> listItems;
    private LayoutInflater layoutInflater;
    public WordAdapter(Context context)
    {
        layoutInflater = LayoutInflater.from(context);
    }

    public List<WordList> getListItems() {  return listItems;  }
    public void setListItems(List<WordList> listItems) {  this.listItems = listItems;  }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override  public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ListItemView myListItemView;
        if (convertView == null) {
            myListItemView = new ListItemView();
            convertView = layoutInflater .inflate(R.layout.word_item, null);
            myListItemView.setWord_id((TextView) convertView  .findViewById(R.id.word_id));
            myListItemView.setWord_name((TextView) convertView  .findViewById(R.id.word_name));
            myListItemView.setWord_meaning((TextView) convertView  .findViewById(R.id.word_meaning));
            myListItemView.setWord_sample((TextView) convertView  .findViewById(R.id.word_sample));
            convertView.setTag(myListItemView);
        } else {
            myListItemView = (ListItemView) convertView.getTag();
        }
        myListItemView.getWord_id()  .setText(listItems.get(position).getId());
        myListItemView.getWord_name().setText(listItems.get(position).getName());
        myListItemView.getWord_meaning().setText(  listItems.get(position).getMeaning());
        myListItemView.getWord_sample().setText(  listItems.get(position).getSample());
        return convertView;
    }

    class ListItemView {
        private TextView word_id;
        private TextView word_name;
        private TextView word_meaning;
        private TextView word_sample;

        public TextView getWord_id() {
            return word_id;
        }

        public void setWord_id(TextView word_id) {
            this.word_id = word_id;
        }

        public TextView getWord_name() {
            return word_name;
        }

        public void setWord_name(TextView word_name) {
            this.word_name = word_name;
        }

        public TextView getWord_meaning() {
            return word_meaning;
        }

        public void setWord_meaning(TextView word_meaning) {
            this.word_meaning = word_meaning;
        }

        public TextView getWord_sample() {
            return word_sample;
        }

        public void setWord_sample(TextView word_sample) {
            this.word_sample = word_sample;
        }
    }
}

