package com.twtstudio.one.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twtstudio.one.R;
import com.twtstudio.one.model.OneBean;

import java.util.List;

/**
 * Created by jcy on 2016/5/9.
 */
public class InfoFragment extends Fragment implements InfoView{

    RecyclerView recyclerview;
    public static InfoFragment newInstance() {

        Bundle args = new Bundle();

        InfoFragment fragment = new InfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.info_fragment,container,false);
        recyclerview= (RecyclerView) view.findViewById(R.id.reccylerview);
        return recyclerview;
    }

    @Override
    public void setInfoListView(List<OneBean> oneBeanList) {

    }

    @Override
    public void updateInfoList(List<OneBean> newOneBeanList) {

    }
}
