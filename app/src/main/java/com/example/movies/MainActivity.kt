package com.example.movies

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.movies.controller.Controller

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Controller példányosítása amin keresztül lekérünk adatokat a modellből
        val controller : Controller = Controller(applicationContext)

        val posterTest : ImageView = findViewById(R.id.posterTest)
        val titleTest : TextView = findViewById(R.id.titleTest)
        val plotTest : TextView = findViewById(R.id.plotTest)

        if(BuildConfig.DEBUG) {
            val movieTest = controller.getMovieData(0)
            val msg : String = "Movie data from view: $movieTest"
            Log.d("ViewData", msg)

            var rotsCast = controller.getMovieCast(2)
            Log.d("Rots cast", rotsCast.toString())

            var cast = mutableListOf<MutableList<Pair<String, String>>>()
            for (i in 0 until controller.getMoviesCount()) {
                cast.add(controller.getMovieCast(i))
            }           
            Log.d("Cast", cast.toString())
            var movieData = controller.getMovieData(0)
            Log.d("movie0", movieData.toString())
        }

        //ImageView kép állítása kódból
        val path = "android.resource://$packageName/drawable/"
        val uri : Uri = Uri.parse("$path${controller.getPosterName(0)}")
        posterTest.setImageURI(null);
        posterTest.setImageURI(uri)

        //Többi példa elem lekérdezése
        titleTest.text = controller.getMovieTitle(0)
        plotTest.text = controller.getMoviePlot(0)

    }
}