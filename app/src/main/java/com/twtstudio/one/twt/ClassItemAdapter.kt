package com.twtstudio.one.twt

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext

/**
 * Created by retrox on 16/10/2017.
 */
class ClassItemAdapter(val courseList: List<ClassTable.TermDataBean.DataBean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int  = courseList.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder?, position: Int) {
        val course = courseList[position]
        if (viewHolder is ClassItemViewHolder){
            viewHolder.itemUI.apply {
                courseName.update(course.coursename)
                val locationStr = course.arrange?.get(0)?.room
                location.update(locationStr)
                teacherName.update(course.teacher)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ClassItemViewHolder.ClassItemUi().createView(AnkoContext.Companion.create(parent.context,parent)).tag as ClassItemViewHolder
    }

}