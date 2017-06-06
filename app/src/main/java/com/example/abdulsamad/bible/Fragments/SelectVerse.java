package com.example.abdulsamad.bible.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.abdulsamad.bible.Adapters.ChapterAdapter;
import com.example.abdulsamad.bible.DataProviders.ChapterDataProvider;
import com.example.abdulsamad.bible.R;

import java.util.ArrayList;

/**
 * Created by ABDUL Samad on 5/8/2017.
 */
public class SelectVerse extends Fragment {
    ChapterAdapter adapter;
    GridView gridview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_verse, null, false);
        gridview=(GridView)view.findViewById(R.id.gridView);
        loadChapters();
        return  view;
    }
    private ArrayList<ChapterDataProvider> getData() {

        final ArrayList<ChapterDataProvider> imageItems = new ArrayList<>();
        for (int i=0;i<30;i++) {
            imageItems.add(new ChapterDataProvider("1"));
        }
        return imageItems;
    }
    private void loadChapters()
    {
        adapter = new ChapterAdapter(getActivity(), R.layout.customview_chapter, getData());
        gridview.setAdapter(adapter);
    }
}