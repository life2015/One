package com.twtstudio.one

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Gravity
import com.twt.wepeiyang.commons.network.RetrofitProvider
import com.twtstudio.one.twt.ClassItemAdapter
import com.twtstudio.one.twt.ClassItemViewHolder
import com.twtstudio.one.twt.ScheduleApi
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk25.listeners.onClick
import kotlinx.coroutines.experimental.android.UI
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.coroutines.experimental.bg


/**
 * Created by retrox on 27/08/2017.
 */
class AnkoActivity : AppCompatActivity() {
    val api = RetrofitProvider.getRetrofit().create(ScheduleApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView {
            layoutManager = LinearLayoutManager(this@AnkoActivity)
//            adapter = ClassItemAdapter()
            async(UI) {
                val reponse = bg {
                    api.getClassTable().execute().body()
                }.await()

                reponse?.data?.data?.apply {
                    toast("你这个学期一共有${this.size}门课程")
                    adapter = ClassItemAdapter(this)
                }
                
            }

        }
    }

    private fun log(str: String?) {
        Log.d("anko", str)
    }

    fun test() {
        val dao = OneApp.getDb().userDao()

        recyclerView {
            layoutManager = LinearLayoutManager(this@AnkoActivity)
            doAsync {
                val list = dao.all
                uiThread {
                    adapter = UserAnkoAdapter(list)
                }
            }
        }

    }

    fun oldlayout() {
        verticalLayout {

            val textview = textView("init")
            button("request") {

                onClick {
                    async(UI) {
                        val reponse = bg {
                            api.getClassTable().execute().toString()
                        }.await()

                        textview.text = reponse
                        log(reponse)
                    }.invokeOnCompletion {
                        it?.printStackTrace()
                    }
                }
            }
        }
    }
}