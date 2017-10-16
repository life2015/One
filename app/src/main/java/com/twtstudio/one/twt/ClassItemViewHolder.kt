package com.twtstudio.one.twt

import android.graphics.Color
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.twtstudio.one.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import rx.subjects.PublishSubject

/**
 * Created by retrox on 16/10/2017.
 */
class ClassItemViewHolder(val itemUI: ClassItemUi, itemView: View?) : RecyclerView.ViewHolder(itemView) {


    class ClassItemUi : AnkoComponent<ViewGroup> {

        val location = PublishSubject.create<String>()
        val courseName = PublishSubject.create<String>()
        val teacherName = PublishSubject.create<String>()

        override fun createView(ui: AnkoContext<ViewGroup>): View {
            with(ui) {
                val itemView = cardView {
                    radius = 10f
                    cardElevation = 8f
//                    horizontalPadding = dip(16)
                    setCardBackgroundColor(Color.parseColor("#8071FF"))
//                    backgroundColor = Color.parseColor("#0ac3d5")


                    verticalLayout {

                        padding = dip(16)
                        textView("课程名") {
                            textSize = 20f
                            courseName.bind(this)
                        }.lparams {
                            gravity = Gravity.START
                        }

                        textView("地点") {
                            textSize = 20f
                            location.bind(this)

                        }.lparams {
                            gravity = Gravity.END
                        }

                        textView("老师名字") {
                            textSize = 20f
                            teacherName.bind(this)
                        }.lparams {
                            gravity = Gravity.END
                        }

                    }

                }.apply {
                    layoutParams = with(FrameLayout.LayoutParams(matchParent, wrapContent)) {
                        leftMargin = dip(4)
                        rightMargin = dip(4)
                        topMargin = dip(8)
                        this
                    }
                }
                itemView.tag = ClassItemViewHolder(this@ClassItemUi, itemView)
                return itemView
            }
        }



    }


}