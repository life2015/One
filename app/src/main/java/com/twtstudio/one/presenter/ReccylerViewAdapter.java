package com.twtstudio.one.presenter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.twtstudio.one.R;
import com.twtstudio.one.model.OneBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcy on 2016/5/9.
 */
public class ReccylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    List<OneBean> beanList=new ArrayList<>();
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.from(context).inflate(R.layout.item,parent,false);

        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        InfoViewHolder infoViewHolder= (InfoViewHolder) holder;

    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
    static class InfoViewHolder extends RecyclerView.ViewHolder
    {

        CardView cardView;
        ImageView imageView;
        TextView infoTextView;
        TextView dateTextView;
        public InfoViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView.findViewById(R.id.card_view);
            imageView= (ImageView) itemView.findViewById(R.id.image_one);
            infoTextView= (TextView) itemView.findViewById(R.id.text_one);
            dateTextView= (TextView) itemView.findViewById(R.id.date_text);
        }
    }

}
