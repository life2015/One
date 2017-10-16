package com.twtstudio.one.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.Palette
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.twtstudio.one.Bean.BeanListMonth
import com.twtstudio.one.R
import com.twtstudio.one.model.ApiClient
import com.twtstudio.one.presenter.InfoBeanPresenterImpl
import org.jetbrains.anko.find

/**
 * Created by retrox on 08/04/2017.
 *
 * 这里并没有严格遵循MVP，因为逻辑不复杂，写在activity里面会看起来更加直观一些
 */
class VActivity : AppCompatActivity() {

    val layoutManger = VirtualLayoutManager(this)
    val recyclerview by lazy {
        find<RecyclerView>(R.id.recyclerview).apply {
            layoutManager = this@VActivity.layoutManger
            recycledViewPool = RecyclerView.RecycledViewPool()
                    .apply { setMaxRecycledViews(0, 20) }
        }
    }


    val delegateAdapter = DelegateAdapter(layoutManger, true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vlayout_main)
        recyclerview.adapter = delegateAdapter

        val api = ApiClient(InfoBeanPresenterImpl(InfoFragment(), this))
        val list1 = ArrayList<BeanListMonth.DataBean>()
        val list2 = ArrayList<BeanListMonth.DataBean>()
        val list3 = ArrayList<BeanListMonth.DataBean>()

        val singleHelper = SingleLayoutHelper()
        singleHelper.setMargin(0,16,0,0)
        //顶部的小标题条目
        delegateAdapter.addAdapter(SimpleItemAdapter(this,singleHelper))

        val gridHelper = GridLayoutHelper(2)
        gridHelper.bgColor = Color.WHITE

        // 就是一个高阶函数
        api.getasList {
            // 把返回的数据分成三部分，用不同的布局展示
            it.forEachIndexed { index, dataBean ->
                when (index) {
                    in 0..10 -> {
                        list1.add(dataBean)
                        if (index == 10)
                            delegateAdapter.addAdapter(SubAdapter(this, gridHelper, list1))
                    }
                    in 11..20 -> {
                        list2.add(dataBean)
                        if (index == 20)
                            delegateAdapter.addAdapter(SubAdapter(this, StaggeredGridLayoutHelper(2), list2))
                    }
                    else -> {
                        list3.add(dataBean)
                        if (index == it.size-1)
                            delegateAdapter.addAdapter(SubAdapter(this, LinearLayoutHelper(), list3))
//                        delegateAdapter.notifyDataSetChanged()
                    }
                }
            }
        }

    }

    class SubAdapter(val context: Context, val layoutHelper: LayoutHelper, val data: List<BeanListMonth.DataBean>) : DelegateAdapter.Adapter<SubAdapter.InfoViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): InfoViewHolder {

            val view = LayoutInflater.from(context).inflate(R.layout.item, parent,false)
            return InfoViewHolder(view)
        }

        override fun onBindViewHolder(holder: InfoViewHolder?, position: Int) {
            holder?.let {
                holder.infoTextView.text = data[position].hp_content
                holder.authorTextView.text = data[position].hp_author
                Glide.with(context).load(data[position].hp_img_url)
                        .asBitmap().error(R.drawable.one_pic)
                        .into(holder.imageView)
            }
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onCreateLayoutHelper(): LayoutHelper {
            return layoutHelper
        }

        class InfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var cardView: CardView = itemView.findViewById(R.id.card_view)
            var imageView: ImageView = itemView.findViewById(R.id.image_one)
            var infoTextView: TextView = itemView.findViewById(R.id.text_one)
            var authorTextView: TextView = itemView.findViewById(R.id.author)

        }

    }

    class SimpleItemAdapter(val context: Context, val layoutHelper: LayoutHelper) : DelegateAdapter.Adapter<SimpleItemAdapter.SimpleItemHolder>(){


        override fun onCreateLayoutHelper(): LayoutHelper {
            return layoutHelper
        }

        override fun onBindViewHolder(holder: SimpleItemHolder?, position: Int) {
//            TODO("not implemented")
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SimpleItemHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.item_simple_title,parent,false)
            return SimpleItemHolder(view)
        }

        override fun getItemCount(): Int {
            return 1
        }

        class SimpleItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textView = itemView.findViewById<TextView>(R.id.textView)
        }
    }



}