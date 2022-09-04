package com.example.movies

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
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
        val controller: Controller = Controller(applicationContext, packageName)
        //RecyclerView feltöltése listaelemekkel
       // renderRecyclerViewItems(controller, binding)

      /*  binding.searchBar.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            //A kereséskor az enter lenyomása után hívodik meg
            override fun onQueryTextSubmit(filter: String?): Boolean {
                if(BuildConfig.DEBUG) {
                    Log.d("filter", filter.toString())
                }
                renderRecyclerViewItems(controller, binding, true, filter ?: "")
                hideKeyboard(binding.searchBar)
                return true
            }
            //Minden egyes karakter leütése után meghívódik
            override fun onQueryTextChange(filter: String?): Boolean {
                //Ha töröljük a szűrés query-t akkor betölti az összes filmet a listába
                if(filter!!.isEmpty())
                    renderRecyclerViewItems(controller, binding)
                return true
                TODO("not implemented")
            }
        })

        //Ha kikattintunk a SearchView-ből akkor bezáródik a keyboard
        binding.searchBar.setOnQueryTextFocusChangeListener  { _, hasFocus ->
            if(!hasFocus)
                hideKeyboard(binding.searchBar)
        }*/
    }


    /*//Megjeleníti a szűrt vagy összes elérhető filmet a RecyclerView-ben
    private  fun renderRecyclerViewItems(controller: Controller, binding : ActivityMainBinding, applyFilter : Boolean = false, filter : String = "") {
        val movieData = if (applyFilter && filter != "") controller.getFilteredMoviesData(filter) else controller.getAllMoviesData()
        val posterUris : List<Uri> = if (applyFilter && filter != "") controller.getFilteredPosterUris(movieData) else controller.getAllPosterUri()

        val adapter = MovieAdapter(movieData, posterUris)
        binding.listOfMovies.adapter = adapter
        binding.listOfMovies.layoutManager = LinearLayoutManager(applicationContext)
        adapter.setOnItemClickListener(object : MovieAdapter.onItemClickListener{
            override fun onItemClick(view : View, position: Int) {
                //Id kiszedése a tag-ből
                val id = view.tag.toString().split('_')[1].toInt()
                val title = controller.getMovieTitle(id)
                Toast.makeText(applicationContext, "A következő filmet választottad ki: $title", Toast.LENGTH_SHORT).show()
            }
        })
    }
*/

    //A keyboard eltűntetése sikeres szűrés után
    private fun hideKeyboard(view: View) {
        view.apply {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}