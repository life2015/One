package com.twtstudio.one.twt

import android.widget.TextView
import rx.subjects.PublishSubject

/**
 * Created by retrox on 16/10/2017.
 */

fun PublishSubject<String>.bind(view: TextView) {
    this.subscribe {
        view.setText(it)
    }
}

fun PublishSubject<String>.update(value: String?) {
    this.onNext(value)
}