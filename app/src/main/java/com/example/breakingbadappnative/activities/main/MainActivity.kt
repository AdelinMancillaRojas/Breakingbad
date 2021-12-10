package com.example.breakingbadapp.activities.main

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.breakingbadapp.R
import com.example.breakingbadapp.databinding.ActivityMainBinding
import com.example.breakingbadappnative.activities.menuActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bindingLogin = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )

        bindingLogin.btnlogin.setOnClickListener {
            if (bindingLogin.email.text.isEmpty()) {
                Toast.makeText(this, "Empty Email", Toast.LENGTH_LONG).show()
            } else
                if (bindingLogin.password.text.isEmpty()) {
                    Toast.makeText(this, "Empty Password", Toast.LENGTH_LONG).show()
                } else {
                    val intent = Intent(this, menuActivity::class.java)
                    startActivity(intent)
                }
        }
    }

}