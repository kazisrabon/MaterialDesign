package com.example.iit.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by IIT on 4/8/2015.
 */
public class SimpleHeaderRecyclerAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 1;

    private LayoutInflater mInflater;
    private ArrayList<String> mItems;
    private View mHeaderView;
    private static Context context;

    public SimpleHeaderRecyclerAdapter2(Context context, ArrayList<String> items, View headerView) {
        mInflater = LayoutInflater.from(context);
        mItems = items;
        mHeaderView = headerView;
        this.context = null;
    }

    @Override
    public int getItemCount() {
        if (mHeaderView == null) {
            return mItems.size();
        } else {
            return mItems.size() + 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0) ? VIEW_TYPE_HEADER : VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_HEADER) {
            return new HeaderViewHolder(mHeaderView);
        } else {
//            return new ItemViewHolder(mInflater.inflate(android.R.layout.simple_list_item_1, parent, false));
            View view = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
//            ViewHolder vh = new ViewHolder(view);
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.e("Error", "Clicked");
////                    start
//                }
//            });
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        if (viewHolder instanceof ItemViewHolder) {
            final String name = mItems.get(position - 1);
            Log.e("Favorite listview", name);
            ((ItemViewHolder) viewHolder).textView.setText(mItems.get(position - 1));
            ((ItemViewHolder) viewHolder).textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(context != null){
//                        Toast.makeText(context, "hlw"+name, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context, ParallaxToolbarScrollViewActivity.class);
                        intent.putExtra("position2", name);
                        context.startActivity(intent);
                    }
//                    Toast.makeText(context, position, Toast.LENGTH_LONG).show();

                }
            });
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ItemViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(android.R.id.text1);
            context = view.getContext();
        }
    }
}