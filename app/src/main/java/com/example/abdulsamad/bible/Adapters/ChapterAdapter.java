package com.example.abdulsamad.bible.Adapters;

/**
 * Created by Apple on 10/2/2016.
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.abdulsamad.bible.DataProviders.ChapterDataProvider;
import com.example.abdulsamad.bible.R;


import java.util.ArrayList;

/**
 * Created by Apple on 9/29/2016.
 */
public class ChapterAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private ArrayList data = new ArrayList();
    public ChapterAdapter(Context context, int layoutResourceId, ArrayList data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.data = data;
        this.context=context;
    }
    static class ViewHolder {
        TextView chapter;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final  ViewHolder holder ;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.chapter = (TextView) row.findViewById(R.id.chapter);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        ChapterDataProvider item = (ChapterDataProvider) data.get(position);
        holder.chapter.setText(item.getChapter());
        return row;
    }
}