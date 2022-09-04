package com.example.movies.controller

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.MovieAdapter
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.model.Model

class Controller(context : Context, packageName : String) {
    private val model : Model
    private val context : Context
    private val packageName : String
    init {
        this.context = context
        this.model = Model(context)
        this.packageName = packageName
    }

    //Egy adott film adatait adja vissza id alapján Movie objektumként
    fun getMovieData(id : Int) : Model.Movie {
        return this.model.moviesData[id]
    }

    //Összes film adatait adja vissza listaként melynek minden eleme egy Movie objektum
    fun getAllMoviesData() : List<Model.Movie> {
        return this.model.moviesData
    }

    //Egy adott film címét adja vissza id alapján
    fun getMovieTitle(id : Int) : String {
        return this.model.moviesData[id].title
    }

    //Egy adott film megjelenési dátumát adja vissza id alapján
    fun getMovieReleasedDate(id : Int) : String {
        return this.model.moviesData[id].released
    }

    //Egy adott film leírását adja vissza id alapján
    fun getMoviePlot(id : Int) : String {
        return this.model.moviesData[id].plot
    }
/*
    //Egy adott film műfajait adja vissza id alapján listaként amiben stringekként
    // szerepelnek az individuális műfajok
    fun getMovieGenres(id : Int) : List<String> {
        return movieGenresToList(this.model.moviesData[id].genre)
    }

    //Átkonvertálja a string műfaj adatokat listává
    fun movieGenresToList(genres : String) : List<String> {
        return genres.replace(" ", "").split(",")
    }

    //Egy adott film hosszát adja vissza id alapján
    fun getMoviePlayTime(id : Int) : String {
        return this.model.moviesData[id].playtime
    }

    //Egy adott film rendezőjének nevét adja vissza id alapján
    fun getMovieDirector(id : Int) : String {
        return this.model.moviesData[id].director
    }

    //Egy adott film elkészítési költségét adja vissza id alapján
    fun getMovieCost(id : Int) : String {
        return this.model.moviesData[id].cost
    }

    //Egy adott film bevételi értékét adja vissza id alapján
    fun getMovieProfit(id : Int) : String {
        return this.model.moviesData[id].profit
    }

    //Egy adott filmhez tartozó színészek neveit adja vissza MutableList-ben, ahol a színészek nevei
    // és az általuk játszott karakter egy Pair<String, String> objektumban van realizálva
    fun getMovieCast(id : Int) : MutableList<Pair<String, String>> {
        return movieCastToMutableList(this.model.moviesData[id].cast)
    }

    //Feldolgozza a cast stringet egy MutableList<Pair<String, String>> adatszerkezetbe
    fun movieCastToMutableList(cast : String) : MutableList<Pair<String, String>> {
        var castInfo : MutableList<Pair<String, String>> = mutableListOf()
        val actors = cast.split(',')
        for(actor in actors) {
            val temp = actor.split("#")
            castInfo.add(Pair(temp[0], temp[1]))
        }
        return castInfo
    }

    //Egy adott film poszterének nevét adja vissza id alapján
    fun getPosterName(id : Int) : String  {
        return this.model.moviesData[id].poster
    }

    //Visszaadja egy film poszterének Uri címét id alapján, amit utána
    // pl egy ImageView-nak be lehet állítani .setImageUri() metódussal
    fun getPosterUri(id : Int) : Uri {
        val path = "android.resource://${this.packageName}/drawable/"
        return Uri.parse("$path${getPosterName(id)}")
    }

    //Visszaadja minden filmhez tartozó posztert
    fun getAllPosterUri() : List<Uri> {
        val listOfImages = mutableListOf<Uri>()
        for (i in 0 until getMoviesCount()) {
            listOfImages.add(getPosterUri(i))
        }
        return listOfImages
    }

    //Az elérhető filmek számát adja vissza
    fun getMoviesCount() : Int {
        return this.model.moviesData.count()
    }

    //Visszaadja a szűrt filmlistát
    fun getFilteredMoviesData(filter : String): List<Model.Movie> {
        return this.model.getFilteredMovies(filter.lowercase())
    }

    //Leképezi a kiszűrt filmlista alapján a poster urikat egy listába
    fun getFilteredPosterUris(filteredMovies : List<Model.Movie>) : List<Uri> {
        return filteredMovies.map { this.getPosterUri(it.id) }
    }*/
}