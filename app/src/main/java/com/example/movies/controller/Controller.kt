package com.example.movies.controller

import android.content.Context
import com.example.movies.model.Model

class Controller(context : Context) {
    private val model : Model
    private val context : Context
    init {
        this.context = context
        this.model = Model(context)
        this.model.moviesData
    }
}