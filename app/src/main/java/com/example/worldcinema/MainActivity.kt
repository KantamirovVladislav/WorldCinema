package com.example.worldcinema

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcinema.model.Data

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var button2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button = findViewById(R.id.AuthButton)
        button.setOnClickListener{
            Intent(this, FilmsListActivity::class.java).apply {
                startActivity(this)
            }
        }

        button2 = findViewById(R.id.RegistrationButton)
        button2.setOnClickListener{
            Intent(this, Registration::class.java).apply {
                startActivity(this)
            }
        }

    }
}