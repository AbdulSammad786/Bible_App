package com.example.abdulsamad.bible.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.abdulsamad.bible.R;
/**
 * Created by ABDUL Samad on 5/8/2017.
 */
public class ReadBook extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.read_books_fragment, null, false);
        RelativeLayout selection=(RelativeLayout)view.findViewById(R.id.selectionlayout);
        selection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager=getActivity().getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.container,new SelectionTabs()).commit();
            }
        });
        return  view;
    }

}