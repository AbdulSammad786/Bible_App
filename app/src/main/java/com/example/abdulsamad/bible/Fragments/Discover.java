package com.example.abdulsamad.bible.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.abdulsamad.bible.R;
/**
 * Created by ABDUL Samad on 6/6/2017.
 */

public class Discover  extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discover_fragment, null, false);
      return  view;
    }
}