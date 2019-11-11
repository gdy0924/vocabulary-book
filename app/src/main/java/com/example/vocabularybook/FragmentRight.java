package com.example.vocabularybook;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRight extends ListFragment {


    public FragmentRight() {
        // Required empty public constructor
    }

    public LayoutInflater mInflater;

//    public static final String LeftListFragmentTag = "leftListFragmentTag";
//    public static FragmentRight newInstance(String str){
//        FragmentRight leftListFragment = new FragmentRight();
//        Bundle bundle = new Bundle();
//        bundle.putString(LeftListFragmentTag,str);
//        leftListFragment.setArguments(bundle);
//        return leftListFragment;
//    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInflater = getActivity().getLayoutInflater();
        //refreshData(0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = mInflater.inflate(R.layout.fragment_right_list,container,false);
        return view;
    }

//    public void refreshData(int position){
//        this.setListAdapter(new SimpleAdapter(this.getActivity(),getData(position),R.layout.fragment_right,from,to));
//    }
//
//    final String[] from = {"title","info"};////下面会使用SimpleAdapter,此数组中的内容将作为map中的key，构造SimpleAdapter时要求传入List集合，List中的元素要求是map
//    final int[] to = new int[]{R.id.class_name,R.id.teacher_name};//listview中某一项布局的子元素id//将数组中的内容修改为R.id.title,R.id.info更好理解些
//    String[] className = {"英语","文学鉴赏","电影鉴赏","数据结构","大学物理","体育"};//将className数组名修改为classNameInfo更好理解些
//    String[] teacher = {"王五","李四","李磊","董卿","张雪","李梅梅"};
//    //将teacher数组名修改为teacherInfo更好理解些
//    public List<Map<String,Object>> getData(int position){
//        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
//        //为listview添加一项内容，这项内容使用的布局文件是layout_listview_item.xml文件
//        //layout_listview_item.xml布局文件有两个textview,key为title的使用一个textview/class_name
//        //key为info的使用一个textview/teacher_name
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("title","课程名称");
//        map.put("info",className[position]);
//        list.add(map);
//
//
//        map = new HashMap<String,Object>();
//        map.put("title","教师名称");
//        map.put("info",teacher[position]);
//        list.add(map);
//        return list;
//    }
//
//
//
//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//
//    }

}
