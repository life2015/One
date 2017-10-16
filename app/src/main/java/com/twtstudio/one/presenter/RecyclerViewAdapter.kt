package com.twtstudio.one.presenter

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.support.v7.graphics.Palette
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.twtstudio.one.Bean.BeanListMonth
import com.twtstudio.one.ContentAct
import com.twtstudio.one.R
import com.twtstudio.one.Bean.BeanListMonth.DataBean
import com.vipul.hp_hp.library.Layout_to_Image

import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.util.ArrayList

/**
 * Created by jcy on 2016/5/9.
 */
class RecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mInflater: LayoutInflater? = null
    var beanList: MutableList<BeanListMonth.DataBean> = ArrayList()

    override fun getItemViewType(position: Int): Int {
        if (position + 1 >= itemCount) {
            return TYPE_FOOTER
        } else
            return TYPE_NORMAL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null
        val view: View
        when (viewType) {
            TYPE_NORMAL -> {
                view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
                viewHolder = InfoViewHolder(view)
                return viewHolder
            }
            TYPE_FOOTER -> {
                view = LayoutInflater.from(context).inflate(R.layout.footer, parent, false)
                viewHolder = footerViewHolder(view)
                return viewHolder
            }
        }
        return viewHolder!!
    }

    fun insert(bean: BeanListMonth.DataBean) {
        beanList.add(bean)
        this.notifyItemInserted(beanList.size)
    }

    fun addList(dataBeanList: List<BeanListMonth.DataBean>) {
        beanList.addAll(dataBeanList)
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == TYPE_NORMAL) {
            val infoViewHolder = holder as InfoViewHolder
            //infoViewHolder.imageView.setImageResource(R.drawable.one_pic);
            infoViewHolder.infoTextView.text = beanList[position].hp_content
            infoViewHolder.authorTextView.text = beanList[position].hp_author

            Glide.with(context).load(beanList[position].hp_img_url)
                    .asBitmap().error(R.drawable.one_pic)
                    .into(object : BitmapImageViewTarget(infoViewHolder.imageView) {
                        override fun onResourceReady(resource: Bitmap, glideAnimation: GlideAnimation<in Bitmap>?) {
                            super.onResourceReady(resource, glideAnimation)
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                Palette.from(resource).generate { palette ->
                                    val color = palette.getLightMutedColor(0x000000)
                                    infoViewHolder.cardView.setBackgroundColor(color)
                                }
                            }
                        }

                    })
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


            //todo 保存图片操作

//            infoViewHolder.cardView.setOnClickListener { v ->
//                val layoutToImage = Layout_to_Image(context, v)
//                val bitmap = layoutToImage.convert_layout()
//                val appdir = File(Environment.getExternalStorageDirectory(), "One")
//                if (!appdir.exists()) {
//                    appdir.mkdir()
//                }
//                val fileName = System.currentTimeMillis().toString() + ".jpg"
//                val file = File(appdir, fileName)
//                try {
//                    file.createNewFile()
//                    val fos = FileOutputStream(file)
//                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
//                    fos.flush()
//                    fos.close()
//                } catch (e: FileNotFoundException) {
//                    e.printStackTrace()
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                }
//            }

        }
    }

    override fun getItemCount(): Int {
        return beanList.size
    }

    internal class InfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var cardView: CardView
        var imageView: ImageView
        var infoTextView: TextView
        var authorTextView: TextView

        init {
            cardView = itemView.findViewById(R.id.card_view)
            imageView = itemView.findViewById(R.id.image_one)
            infoTextView = itemView.findViewById(R.id.text_one)
            authorTextView = itemView.findViewById(R.id.author)
        }
    }

    internal class footerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {

        val TYPE_FOOTER = 2//底部--往往是loading_more
        val TYPE_NORMAL = 1 // 正常的一条文章
    }

}
