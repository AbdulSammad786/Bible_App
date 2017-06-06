package com.example.abdulsamad.bible.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.abdulsamad.bible.DataProviders.BooksDataProvider;
import com.example.abdulsamad.bible.R;


import java.util.ArrayList;

/**
 * Created by DELL on 24-08-2016.
 */
public class BooksAdapter extends BaseAdapter {
    Context context;
    ArrayList<BooksDataProvider> serviceManualArrayList;
    LayoutInflater inflater;
    public BooksAdapter(Context context, ArrayList<BooksDataProvider> serviceManualArrayList) {
        this.context = context;
        this.serviceManualArrayList = serviceManualArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return serviceManualArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null) {
            holder = new Holder();
            view = inflater.inflate(R.layout.customview_listofbooks, viewGroup, false);
            holder.id = (TextView) view.findViewById(R.id.id);
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        BooksDataProvider serviceManual = serviceManualArrayList.get(i);
        holder.id.setText(serviceManual.getId());
        holder.name.setText(serviceManual.getName());
        return view;
    }
    class Holder {
        TextView id,name;
    }
}