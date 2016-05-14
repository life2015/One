package com.twtstudio.one.presenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.twtstudio.one.Bean.BeanListMonth;
import com.twtstudio.one.ContentAct;
import com.twtstudio.one.R;
import com.twtstudio.one.Bean.BeanListMonth.DataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcy on 2016/5/9.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public final static int TYPE_FOOTER = 2;//底部--往往是loading_more
    public final static int TYPE_NORMAL = 1; // 正常的一条文章
    private LayoutInflater mInflater;
    private Context context;
    List<BeanListMonth.DataBean> beanList=new ArrayList<>();

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position+1>=getItemCount())
        {
            return TYPE_FOOTER;
        }
        else return TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        View view;
        switch (viewType)
        {
            case TYPE_NORMAL:
                view=mInflater.from(context).inflate(R.layout.item,parent,false);
                viewHolder= new InfoViewHolder(view);
                return viewHolder;
            case TYPE_FOOTER:
                view=mInflater.from(context).inflate(R.layout.footer,parent,false);
                viewHolder=new footerViewHolder(view);
                return viewHolder;
        }
        return viewHolder;
    }

    public void insert(BeanListMonth.DataBean bean)
    {
        beanList.add(bean);
        this.notifyItemInserted(beanList.size());
    }
    public void addList(List<BeanListMonth.DataBean> dataBeanList)
    {
        beanList.addAll(dataBeanList);
        this.notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if(getItemViewType(position)==TYPE_NORMAL)
        {
            final InfoViewHolder infoViewHolder = (InfoViewHolder) holder;
            //infoViewHolder.imageView.setImageResource(R.drawable.one_pic);
            infoViewHolder.infoTextView.setText(beanList.get(position).getHp_content());
            infoViewHolder.authorTextView.setText(beanList.get(position).getHp_author());

            Glide.with(context).load(beanList.get(position).getHp_img_url())
                    .asBitmap().error(R.drawable.one_pic)
                    .into(new BitmapImageViewTarget(infoViewHolder.imageView){
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            super.onResourceReady(resource, glideAnimation);
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
                            {
                                Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                                    @Override
                                    public void onGenerated(Palette palette) {
                                        int color=palette.getLightMutedColor(0x000000);
                                        infoViewHolder.cardView.setBackgroundColor(color);
                                    }
                                });
                            }
                        }

                    });
            /**
             * cardview点击跳转事件6
             */
//            infoViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(context, ContentAct.class);
//                    Bundle bundle=new Bundle();
//                    bundle.putString("index",beanList.get(position).getHpEntity().getStrMarketTime());
//                    bundle.putString("bitmapurl",beanList.get(position).getHpEntity().getStrOriginalImgUrl());
//                    intent.putExtras(bundle);
//                    //intent.putExtra("stroy_bitmap",bitmapSerziable);
//                    context.startActivity(intent);
//                }
//            });
        }
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
        TextView authorTextView;
        public InfoViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView.findViewById(R.id.card_view);
            imageView= (ImageView) itemView.findViewById(R.id.image_one);
            infoTextView= (TextView) itemView.findViewById(R.id.text_one);
            authorTextView= (TextView) itemView.findViewById(R.id.author);
        }
    }
    static class footerViewHolder extends RecyclerView.ViewHolder
    {

        public footerViewHolder(View itemView) {
            super(itemView);
        }
    }

}
