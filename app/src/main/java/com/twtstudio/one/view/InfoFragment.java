package com.twtstudio.one.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twtstudio.one.Bean.BeanListMonth;
import com.twtstudio.one.R;
import com.twtstudio.one.presenter.InfoBeanPresenterImpl;
import com.twtstudio.one.presenter.InfoBeanPresenter;
import com.twtstudio.one.presenter.RecyclerViewAdapter;

import java.util.List;

/**
 * Created by jcy on 2016/5/9.
 */
public class InfoFragment extends Fragment implements InfoView{

    RecyclerView recyclerview;
    RecyclerViewAdapter adapter;
    InfoBeanPresenter infoBeanPresenter;
    public static InfoFragment newInstance() {

        Bundle args = new Bundle();

        InfoFragment fragment = new InfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        infoBeanPresenter =new InfoBeanPresenterImpl(this,getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.info_fragment,container,false);

        recyclerview= (RecyclerView) view.findViewById(R.id.reccylerview);
        final LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);
        adapter=new RecyclerViewAdapter(getActivity());
        recyclerview.setAdapter(adapter);
        infoBeanPresenter.getData();
//        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
        return view;
    }


    @Override
    public void setInfoListView(List<BeanListMonth.DataBean> oneBeanList) {

    }

    @Override
    public void updateInfoList(List<BeanListMonth.DataBean> newOneBeanList) {

    }

    @Override
    public void insertInfoItem(BeanListMonth.DataBean bean) {
        adapter.insert(bean);
    }

    @Override
    public void addList(List<BeanListMonth.DataBean> dataBeanList) {
        adapter.addList(dataBeanList);
    }
}
