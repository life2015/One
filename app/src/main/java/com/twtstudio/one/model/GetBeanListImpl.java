package com.twtstudio.one.model;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.twtstudio.one.Bean.OneBean;
import com.twtstudio.one.presenter.InfoBeanPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by jcy on 2016/5/9.
 */
public class GetBeanListImpl implements GetBeanList {
    List<OneBean> oneBeanList = new ArrayList<>();
    RequestQueue queue;
    Context context;
    Gson gson = new Gson();
    InfoBeanPresenter infoBeanPresenter;
    String date_string;
    String base_url = "http://211.152.49.184:7001/OneForWeb/one/getHpinfo";
    String url_hpinfo = "http://211.152.49.184:7001/OneForWeb/one/getHpinfo?strDate=";

    /**
     * 构造函数
     */
    public GetBeanListImpl(Context context, InfoBeanPresenter infoBeanPresenter) {
        queue = Volley.newRequestQueue(context);
        this.infoBeanPresenter = infoBeanPresenter;
    }

    List<String> initdate() {
        List<String> datelist = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date currdate=new Date(System.currentTimeMillis());
//        date_string=simpleDateFormat.format(currdate);
//        Log.d("jcy",date_string);
        Calendar calendar = Calendar.getInstance();
        calendar.get(Calendar.DATE);
        //int max=calendar.get(Calendar.DAY_OF_MONTH)+1;
        for (int i = 0; i < 11; i++) {
            String dateString = simpleDateFormat.format(calendar.getTime());
            datelist.add(dateString);
            int day = calendar.get(Calendar.DAY_OF_MONTH) - 1;
            calendar.set(Calendar.DAY_OF_MONTH, day);

        }
//        int day=calendar.get(Calendar.DAY_OF_MONTH);
//        while (calendar.get(Calendar.MONTH)>4)
//        {
//                String dateString=simpleDateFormat.format(calendar.getTime());
//                datelist.add(dateString);
//                day=calendar.get(Calendar.DAY_OF_MONTH)-1;
//                calendar.set(Calendar.DAY_OF_MONTH,day);
//
//        }
        return datelist;
    }

    @Override
    public void getPreInfo() {
//        for (String s:initdate()) {
//            volleypost(s);
//        }
        for (int i = 0; i < initdate().size(); i++) {
            volleypost(initdate().get(i));
        }
    }

    private String urlBuilder(String date) {
        String s = url_hpinfo + date;
        return s;
    }

    private void volleypost(String Date) {
        StringRequest request = new StringRequest(Request.Method.GET, urlBuilder(Date), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                OneBean bean = gson.fromJson(response, OneBean.class);
                if (bean.getHpEntity() != null) {
                    //Log.d("jcyget",bean.getHpEntity().getStrLastUpdateDate());
                    infoBeanPresenter.psotInfoBean(bean);
                    //System.out.println(bean);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("jcy", error.toString());
            }
        });
//        {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String,String> map=new HashMap<>();
//                map.put("strDate","2016-05-09");
//                return map;
//            }
//        };
        request.setRetryPolicy(new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }
}
