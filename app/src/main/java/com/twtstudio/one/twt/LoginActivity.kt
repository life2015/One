package com.twtstudio.one.twt

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import com.twt.wepeiyang.commons.user.AuthSelfBean
import com.twt.wepeiyang.commons.user.UserManager
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.listeners.onClick
import rx.Observer

/**
 * Created by retrox on 14/10/2017.
 */
class LoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            horizontalPadding = dip(16)

            val username = editText("miss976885345") {
                hint = "UserName"
            }
            val password = editText("") {
                hint = "password"
//                inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
            }

            button("login"){
                onClick {
                    val name = username.text.toString()
                    val pass = password.text.toString()

                    UserManager.login(name,pass, object : Observer<AuthSelfBean> {
                        override fun onCompleted() {
                        }

                        override fun onError(e: Throwable?) {
                            toast(e.toString())
                        }

                        override fun onNext(t: AuthSelfBean?) {
                            toast("Login Successful ${t.toString()}")
                        }

                    })
                }
            }
        }
    }
}