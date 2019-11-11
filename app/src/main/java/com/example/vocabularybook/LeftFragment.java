package com.example.vocabularybook;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends ListFragment {


//    public LeftFragment() {
//        // Required empty public constructor
//    }
//
//    final String[] from = {"name","meaning"};////下面会使用SimpleAdapter,此数组中的内容将作为map中的key，构造SimpleAdapter时要求传入List集合，List中的元素要求是map
//    final int[] to = new int[]{R.id.word_name,R.id.word_meaning};//listview中某一项布局的子元素id//将数组中的内容修改为R.id.title,R.id.info更好理解些
//    String[] wordname = {"apple"};//将className数组名修改为classNameInfo更好理解些
//    String[] wordmeaning = {"苹果"};
//
//    public List<Map<String,Object>> getData(int position){
//        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
//        //为listview添加一项内容，这项内容使用的布局文件是layout_listview_item.xml文件
//        //layout_listview_item.xml布局文件有两个textview,key为title的使用一个textview/class_name
//        //key为info的使用一个textview/teacher_name
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","单词");
//        map.put("meaning",wordname[position]);
//        list.add(map);
//
//
//        map = new HashMap<String,Object>();
//        map.put("name","解释");
//        map.put("meaning",wordmeaning[position]);
//        list.add(map);
//        return list;
//    }
//
//
////    String arrays[] = {"星期一","星期二","星期三","星期四","星期五","星期六"};
//
//    public LayoutInflater mInflater;
//
//    public static final String LeftListFragmentTag = "leftListFragmentTag";
//    public static LeftFragment newInstance(String str){
//        LeftFragment leftListFragment = new LeftFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(LeftListFragmentTag,str);
//        leftListFragment.setArguments(bundle);
//        return leftListFragment;
//    }
//
//    @Override
//    public void onCreate( Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mInflater = getActivity().getLayoutInflater();
//        this.setListAdapter(new ArrayAdapter<String>(getActivity(),R.layout.fragment_left,arrays));//为LeftListFragment设置适配器，其中LeftListFragment中的listview的每一项的布局使用系统自带布局android.R.layout.simple_list_item_1(里面只有个textview)
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = mInflater.inflate(R.layout.fragment_right_list,container,false);//解析LeftListFragment的布局文件
//        return view;
//    }
//
//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//        /*DetailFragment detailFragment = new DetailFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(DetailFragment.DetailFragmentArg,String.valueOf(position));
//        detailFragment.setArguments(bundle);
//        getFragmentManager().beginTransaction().replace(R.id.right_fragment,detailFragment).commit();
//        */
//
//        FragmentRight  rightListFragment = (FragmentRight) getFragmentManager().findFragmentByTag("rightListFragment");//当点击LeftListFragment中listview的某一项时，会触发此方法。通过tag找到rightListFragment，MainActivity中add Fragment时设置的此tag，然后调用次Fragment中的refreshData()方法刷新数据，此方法会从新设置adapter
//getFragmentManager().beginTransaction().replace(R.id.list_view,rightListFragment).commit();
//        rightListFragment.refreshData(position);
//
//    }

    private ListView listView;
    private String[] word_name = { "apple", "banana"};
    private String[] word_meaning = { "苹果", "香蕉" };
    private int[] word_id = { 1, 2 };
    private  String[] word_sample={"hhh","bbb"};

    private List<WordList> myListItems;
    private WordAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //listView = (ListView) findViewById(R.id.listView);
        mInflater = getActivity().getLayoutInflater();
        myListItems = new ArrayList<WordList>();
        initData();
        adapter = new WordAdapter(getActivity());
        adapter.setListItems(myListItems);
        listView.setAdapter(adapter);
    }

    public void initData() {
        for (int i = 0; i < word_name.length; i++) {
            WordList wl = new WordList();
            wl.setId(word_id[i]);
            wl.setName(word_name[i]);
            wl.setMeaning(word_meaning[i]);
            wl.setSample(word_sample[i]);
            myListItems.add(wl);
        }
    }

    public LayoutInflater mInflater;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = mInflater.inflate(R.layout.fragment_left_list,container,false);//解析LeftListFragment的布局文件
        return view;
    }

}
