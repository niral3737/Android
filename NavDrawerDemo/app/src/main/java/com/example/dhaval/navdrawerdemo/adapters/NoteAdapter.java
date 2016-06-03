package com.example.dhaval.navdrawerdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dhaval.navdrawerdemo.R;

import java.util.ArrayList;

/**
 * Created by Dhaval on 31/05/2016.
 */
public class NoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> data;
    private LayoutInflater layoutInflater;

    private static final int TYPE_EMPTY = 0;
    private static final int TYPE_ITEM = 1;

    public NoteAdapter(Context context) {

        data = new ArrayList<>();
        data.add("hello 1");
        data.add("hello 2");
        data.add("hello 3");
        data.add("hello 4");
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == TYPE_EMPTY){

            View view = layoutInflater.inflate(R.layout.empty_note, parent, false);
            EmptyHolder emptyHolder = new EmptyHolder(view);
            return emptyHolder;

        }else {

            View view = layoutInflater.inflate(R.layout.custom_note_item, parent, false);
            ItemHolder itemHolder = new ItemHolder(view);
            return itemHolder;

        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if(holder instanceof EmptyHolder){

            // do nothing

        }else {

            final ItemHolder itemHolder = (ItemHolder) holder;
            itemHolder.textView.setText(data.get(position));

            itemHolder.imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeItem(position);
                }
            });
        }

    }

    public void removeItem(int position){
        data.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, data.size());
    }

    @Override
    public int getItemViewType(int position) {
        if(data.size() == 0){
            return TYPE_EMPTY;
        }else {
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        if(data.size() == 0){
            return 1;
        }else {
            return data.size();
        }
    }

    class ItemHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageButton imageButton;
        public ItemHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_note_item);
            imageButton = (ImageButton) itemView.findViewById(R.id.imageButton);

        }

    }

    class EmptyHolder extends RecyclerView.ViewHolder{

        public EmptyHolder(View itemView) {
            super(itemView);
        }
    }
}
