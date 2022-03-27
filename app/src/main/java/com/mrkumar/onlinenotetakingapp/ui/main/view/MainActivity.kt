package com.mrkumar.onlinenotetakingapp.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mrkumar.onlinenotetakingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)




        binding.btnNxtActivity.setOnClickListener {
            val i =Intent(this,GetDataActivity::class.java)
            startActivity(i);
        }
    }
}