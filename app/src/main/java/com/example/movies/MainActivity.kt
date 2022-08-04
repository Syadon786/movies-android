package com.example.movies

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.controller.Controller
import com.example.movies.model.Model
import com.example.movies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Controller példányosítása amin keresztül lekérünk adatokat a modellből
        val controller: Controller = Controller(applicationContext)

        val listOfImages = mutableListOf<Uri>()
        for (i in 0 until controller.getMoviesCount()) {
            listOfImages.add(controller.getPosterUri(i, packageName))
        }
        val adapter = MovieAdapter(controller.getAllMoviesData(), listOfImages)
        binding.listOfMovies.adapter = adapter
        binding.listOfMovies.layoutManager = LinearLayoutManager(this)

    }
}