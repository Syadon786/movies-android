package com.example.movies

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.controller.Controller
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
        adapter.setOnItemClickListener(object : MovieAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val title = controller.getMovieTitle(position)
                Toast.makeText(this@MainActivity, "A következő filmet választottad ki: $title", Toast.LENGTH_SHORT).show()
            }

        })

        binding.searchBar.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            //A kereséskor az enter lenyomása után hívodik meg
            override fun onQueryTextSubmit(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

            //Minden egyes karakter leütése után meghívódik
            override fun onQueryTextChange(p0: String?): Boolean {
                TODO("Not yet implemented")
            }
        })
    }
}