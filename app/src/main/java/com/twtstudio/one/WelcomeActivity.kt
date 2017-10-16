package com.twtstudio.one

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.orhanobut.hawk.Hawk
import com.twtstudio.one.dao.DaoAnkoActivity
import com.twtstudio.one.twt.LoginActivity
import com.twtstudio.one.view.VActivity

/**
 * Created by retrox on 08/04/2017.
 */

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Hawk.init(this).build()
        setContentView(R.layout.activity_welcome)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val button1 = findViewById<Button>(R.id.button2)
        button1.setOnClickListener {
            val intent = Intent(this,VActivity::class.java)
            startActivity(intent)
        }
        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this, AnkoActivity::class.java)
            startActivity(intent)

        }

        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            val intent = Intent(this,DaoAnkoActivity::class.java)
            startActivity(intent)
        }

        val button5 = findViewById<Button>(R.id.button5)
        button5.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
