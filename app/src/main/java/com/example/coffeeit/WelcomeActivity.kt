package com.example.coffeeit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coffeeit.databinding.ActivityWelcomeBinding
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeeit.helpers.CoffeeItemAdapter

class WelcomeActivity : AppCompatActivity() {
    private lateinit var b: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        b = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(b.root)

        setUpToolbar()

        b.layoutLL.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }
    }

    private fun setUpToolbar() {
        setSupportActionBar(b.toolbar)
        supportActionBar?.title = resources.getString(R.string.alt_app_name)
    }


}