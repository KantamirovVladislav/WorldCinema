package com.example.worldcinema

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registration : AppCompatActivity() {
    lateinit var button: Button
    lateinit var button2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)

        button = findViewById(R.id.BackButton)
        button.setOnClickListener{
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
            }
        }

        button2 = findViewById(R.id.RegButton)
        button2.setOnClickListener{
            Intent(this, FilmsListActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}