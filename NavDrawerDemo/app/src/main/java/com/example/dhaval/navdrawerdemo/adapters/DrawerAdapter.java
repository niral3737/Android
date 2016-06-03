package com.example.dhaval.navdrawerdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dhaval.navdrawerdemo.R;

import java.util.ArrayList;

/**
 * Created by Dhaval on 30/05/2016.
 */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.MyViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<String> items = new ArrayList<>();
    Context context;

    public DrawerAdapter(Context context, ArrayList<String> items) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.items = items;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_drawer_row, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textView.setText(items.get(position));
        if(position == items.size()-1){
            holder.divider.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        View divider;

        public MyViewHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            divider = itemView.findViewById(R.id.divider);
        }
    }
}
