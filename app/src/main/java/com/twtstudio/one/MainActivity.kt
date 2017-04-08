package com.twtstudio.one

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.twtstudio.one.view.InfoFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setContentView(R.layout.activity_main);
        val toolbar = findViewById(R.id.toolbar_one) as Toolbar
        setSupportActionBar(toolbar)

        val manager = fragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.container, InfoFragment())
        transaction.commit()

    }


}

