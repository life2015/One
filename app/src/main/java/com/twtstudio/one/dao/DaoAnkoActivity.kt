package com.twtstudio.one.dao

import android.annotation.SuppressLint
import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import com.twtstudio.one.OneApp
import com.twtstudio.one.twt.LoginActivity
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import org.jetbrains.anko.*
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.sdk25.listeners.onClick
import rx.subjects.PublishSubject
import rx.subjects.Subject
import java.net.URL
import kotlin.system.measureTimeMillis

/**
 * Created by retrox on 27/08/2017.
 */
class DaoAnkoActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = OneApp.getDb().userDao()
        val reactText = PublishSubject.create<String>()
        var count = 0
        val liveText = MutableLiveData<String>()

        scrollView {

            verticalLayout {
                padding = dip(10)

                val text = textView(text = "init") {
                    textSize = 20f
                }

                textView("React"){
                    textSize = 16f
                    liveText.observe(this@DaoAnkoActivity, Observer<String> {
                        t: String? ->
                        this.text = t
                    })
                }

                val firstnameEd = editText {
                    hint = "name"
                }.lparams(width = matchParent) {
                    topMargin = dip(16)
                }
                val lastNameEd = editText {
                    hint = "lastname"
                }

                button("Insert") {
                    onClick {
                        val firstname = firstnameEd.text.toString()
                        val lastname = lastNameEd.text.toString()
                        toast("firstName: $firstname --> $lastname")
                        doAsync {
                            val user = User(firstname, lastname)
                            dao.insertAll(user)
                        }
                    }
                }

                button("Auto Insert") {
                    setOnClickListener {
                        val user = User().apply {
                            firstName = "ji123"
                            lastName = "ji"
                        }
                        doAsync {
                            dao.insertAll(user)
                        }
                    }
                }
                button("queryALL") {
                    setOnClickListener {
                        doAsync {
                            val result: List<User>? = dao.all
                            uiThread {
                                text.text = result.toString()
                            }
                        }
                    }
                }

                button("query by name22") {
                    onClick {
                        doAsync {
                            val result: User? = dao.findByName7("ji123", "ji")
                            log(result.toString())
                            uiThread {
                                text.text = result.toString()
                            }
                        }
                    }
                }

                button("React!"){
                    onClick {
                        liveText.value = count.toString()
                        count++
                    }
                }

                button("query test for Coroutines") {
                    onClick {
                        async(UI) {
                            val data1 = bg {
                                dao.all
                            }
                            val data2 = bg {
                                dao.findByName5("ji123", "ji")
                            }
                            val data3: Deferred<User?> = bg {
                                dao.findByName5("sss", "ss")
                            }
                            text.text = "${data1.await()} ===> ${data2.await()} == ${data3.await()?.firstName}"
                            log(data2.await().toString())

                        }.invokeOnCompletion { throwable: Throwable? ->
                            throwable?.printStackTrace()
                        }
                    }
                }

                button("interesting things") {
                    onClick {
                        async(UI){
                            text.text = "loading"
                            val data1 = bg {
                                dao.all
                            }
                            val dataFromNet = bg {
                                URL("https://www.baidu.com").readText().substring(0,500)
                                throw NullPointerException("test")
                            }

                            return@async
//                            dataFromNet
                            text.text = "${fc1()}===>${data1.await()} ===> ${dataFromNet.await()} "

                        }.invokeOnCompletion {
                            it?.printStackTrace()
                        }
                    }
                }

                button("Go") {
                    onClick {
                        val intent = Intent(this@DaoAnkoActivity,LoginActivity::class.java)
                        this@DaoAnkoActivity.startActivity(intent)
                    }
                }

            }

        }
    }

    private suspend fun fc1(): String {
        println("C1 Thread: ${Thread.currentThread()}")
        println("C1 Start")
        delay(3000L)
        println("C1 World! 1")
        return "111"
    }

//    fun View.onClick(block: ()-> Unit) = this.setOnClickListener {
//        block()
//    }


    fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")
}