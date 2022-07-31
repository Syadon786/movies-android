package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies.controller.Controller

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val controller : Controller = Controller(applicationContext)
    }
}