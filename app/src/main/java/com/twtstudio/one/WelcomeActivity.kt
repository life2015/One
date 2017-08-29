package com.twtstudio.one

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.twtstudio.one.view.VActivity

/**
 * Created by retrox on 08/04/2017.
 */

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val button = findViewById(R.id.button) as Button
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val button1 = findViewById(R.id.button2) as Button
        button1.setOnClickListener {
            val intent = Intent(this,VActivity::class.java)
            startActivity(intent)
        }
        val button3 = findViewById(R.id.button3) as Button
        button3.setOnClickListener {
            val intent = Intent(this,AnkoActivity::class.java)
            startActivity(intent)

        }
    }
}
