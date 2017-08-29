package com.twtstudio.one

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*

/**
 * Created by retrox on 27/08/2017.
 */
class AnkoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            padding = dip(10)
            editText {
                hint = "Name"
                textSize = 24f
            }
            editText {
                hint = "Password"
                textSize = 24f
            }
            button("Login") {
                textSize = 26f
            }

            editText {
                hint = "Password"
                textSize = 24f
            }
            button("Login") {
                textSize = 26f
            }
            verticalLayout {
                editText {
                    hint = "Name"
                }
                button("test"){
                    textSize = 10f
                }
            }
            linearLayout {
                button("Login") {
                    textSize = 26f
                }.lparams(width = matchParent) {
                    horizontalMargin = dip(5)
                    topMargin = dip(10)
                }
            }
        }

    }
}