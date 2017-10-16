package com.twtstudio.one

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.twtstudio.one.dao.User
import org.jetbrains.anko.*
import kotlin.properties.Delegates

/**
 * Created by retrox on 13/10/2017.
 */
class UserAnkoAdapter(var userList: List<User>): RecyclerView.Adapter<UserAnkoAdapter.UserItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        return UserItemUI().createView(AnkoContext.create(parent.context,parent)).tag as UserItemViewHolder
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        val user = userList[position]
        holder.itemUi.apply {
            firstName.text = user.firstName
            lastName.text = user.lastName
        }

    }

    override fun getItemCount(): Int = userList.size

    class UserItemUI : AnkoComponent<ViewGroup> {
        var firstName: TextView by Delegates.notNull()
        var lastName: TextView by Delegates.notNull()
        override fun createView(ui: AnkoContext<ViewGroup>): View {

            val itemView = with(ui) {
                verticalLayout {
                    lparams(width = matchParent, height = wrapContent)
                    horizontalPadding = dip(16)

                    firstName = textView {
                        textSize = 16f
                    }

                    lastName = textView()

                    textView {
                        textSize = 26f
                        text = "111"
                    }

                    textView("fuck")
                }
            }

            itemView.tag = UserItemViewHolder(itemView, this)
            return itemView
        }

    }

    class UserItemViewHolder(
            itemView: View?,
            val itemUi: UserItemUI
    ) : RecyclerView.ViewHolder(itemView)


}