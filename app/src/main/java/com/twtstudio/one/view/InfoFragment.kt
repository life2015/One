package com.twtstudio.one.view

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.twtstudio.one.Bean.BeanListMonth
import com.twtstudio.one.R
import com.twtstudio.one.presenter.InfoBeanPresenterImpl
import com.twtstudio.one.presenter.InfoBeanPresenter
import com.twtstudio.one.presenter.RecyclerViewAdapter

/**
 * Created by jcy on 2016/5/9.
 */
class InfoFragment : Fragment(), InfoView {

    var recyclerView: RecyclerView? = null
    val adapter: RecyclerViewAdapter by lazy { RecyclerViewAdapter(activity) }
    var infoBeanPresenter: InfoBeanPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        infoBeanPresenter = InfoBeanPresenterImpl(this, activity)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.info_fragment, container, false)

        recyclerView = view.findViewById(R.id.reccylerview) as RecyclerView
        val layoutManager = LinearLayoutManager(activity)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter
        infoBeanPresenter?.getData()


        //        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
        //            @Override
        //            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        //                super.onScrolled(recyclerView, dx, dy);
        //                int totalcount=layoutManager.getItemCount();
        //                int lastcount=layoutManager.findLastVisibleItemPosition();
        //                if (lastcount+2>=lastcount)
        //                {
        //                    infoBeanPresenter.getData();
        //                }
        //            }
        //        });


        return view
    }


    override fun setInfoListView(oneBeanList: List<BeanListMonth.DataBean>) {

    }

    override fun updateInfoList(newOneBeanList: List<BeanListMonth.DataBean>) {

    }

    override fun insertInfoItem(bean: BeanListMonth.DataBean) {
        adapter.insert(bean)
    }

    override fun addList(dataBeanList: List<BeanListMonth.DataBean>) {
        adapter.addList(dataBeanList)
    }

}
