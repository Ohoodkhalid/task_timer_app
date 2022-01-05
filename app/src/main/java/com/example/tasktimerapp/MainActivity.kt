package com.example.tasktimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var AddNewTask :ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AddNewTask = findViewById(R.id.AddNewTask)

        AddNewTask.setOnClickListener{
            val intent = Intent(this,NewTask::class.java)
            startActivity(intent)

        }
    }
}