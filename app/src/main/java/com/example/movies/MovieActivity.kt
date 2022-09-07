package com.example.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.controller.Controller
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.databinding.ActivityMovieBinding
import com.squareup.picasso.Picasso

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val controller: Controller = Controller(applicationContext, packageName)
        val id = intent.getStringExtra("movieId").toString()
        renderMovieDetails(id, controller, binding)


        binding.btnMvRetry.setOnClickListener {
            renderMovieDetails(id, controller, binding)
            binding.btnMvRetry.visibility = View.INVISIBLE
        }

        binding.btnBack.setOnClickListener {
            this.finish()
        }

    }
    private fun renderMovieDetails(id : String, controller: Controller, binding : ActivityMovieBinding) {
        controller.getMovieDataById(id) { movieData ->
            if(movieData == null) {
                binding.btnMvRetry.visibility = View.VISIBLE
            }
            else {
                Picasso.get().load(movieData.poster).into(binding.ivMvPoster)
                binding.tvMvTitle.text = movieData.title
                binding.tvMvPlot.text = movieData.plot
                binding.tvMvReleased.text = "${movieData.released} (HU)"
                binding.tvMvDirector.text = "Director - ${movieData.director}"

                binding.ivMvPosterCard.visibility = View.VISIBLE
                binding.tvMvTitle.visibility = View.VISIBLE
                binding.tvMvPlotCard.visibility = View.VISIBLE
                binding.tvMvDirector.visibility = View.VISIBLE
                binding.tvMvReleased.visibility = View.VISIBLE
            }
        }
    }
}