package com.example.movies.controller

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.movies.api.VolleyCallBack
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

    //Összes film adatait adja vissza listaként melynek minden eleme egy Movie objektum
    fun getAllMoviesData(callback: (result: List<Model.Movie>?) -> Unit)  {
        model.fetchAllMovie(
                object : VolleyCallBack {
                    override fun onSuccess(result: Any) {
                        callback(result as List<Model.Movie>)
                    }

                    override fun onError(error: String)  {
                        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                    }
                },
            )
    }
}