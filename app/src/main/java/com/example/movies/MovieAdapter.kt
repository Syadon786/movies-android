package com.example.movies

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.databinding.ItemCardBinding
import com.example.movies.model.Model
import com.squareup.picasso.Picasso

class MovieAdapter(
    val movies: List<Model.Movie>,
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    //új kódok a card klikkelésre
    private var mListener: onItemClickListener? = null

    //view paraméterrel kiegészítés, hogy kinyerhessük a taget ne csak a pozíciót, ami csak akkor
    //működik amikor az összes film ki van listázva
    interface onItemClickListener {
        fun onItemClick(view : View, position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(binding, mListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.apply {
            //tag beállítása a film id-ével
            this.root.tag = movies[position].id
            Picasso.get().load(movies[position].poster).into(ivPoster)
            tvMovieTitle.text = movies[position].title
            tvReleased.text = movies[position].released
            tvPlot.text = movies[position].plot
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class MovieViewHolder(val binding: ItemCardBinding, listener: onItemClickListener?) :
        RecyclerView.ViewHolder(binding.root) {
            init {
                itemView.setOnClickListener {
                    listener?.onItemClick(it, bindingAdapterPosition)
                }
            }
        }
}
