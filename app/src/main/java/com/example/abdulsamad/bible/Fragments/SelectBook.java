package com.example.abdulsamad.bible.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.abdulsamad.bible.Adapters.BooksAdapter;
import com.example.abdulsamad.bible.DataProviders.BooksDataProvider;
import com.example.abdulsamad.bible.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ABDUL Samad on 5/8/2017.
 */
public class SelectBook extends Fragment {
    ListView listView;
    ArrayList<BooksDataProvider> arrayList;
    BooksAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_book, null, false);
        listView=(ListView)view.findViewById(R.id.listview);
        arrayList=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            arrayList.add(new BooksDataProvider("1","Mathew"));
        }
        adapter=new BooksAdapter(getActivity(),arrayList);
        listView.setAdapter(adapter);
        return  view;
    }
}