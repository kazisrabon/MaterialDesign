package com.example.iit.materialdesign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by IIT on 4/8/2015.
 */
public class SimpleRecyclerAdapter2 extends RecyclerView.Adapter<SimpleRecyclerAdapter2.ViewHolder> {
    private LayoutInflater mInflater;
    private ArrayList<String> mItems;

    public SimpleRecyclerAdapter2(Context context, ArrayList<String> items) {
        mInflater = LayoutInflater.from(context);
        mItems = items;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
//        view.setOnClickListener();    //onClickListener for Recycler View
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.textView.setText(mItems.get(position));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText("TRANSIENT WATCH");
        }
    }
}