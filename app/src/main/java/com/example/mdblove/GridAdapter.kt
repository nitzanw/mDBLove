package com.example.mdblove

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mdblove.data.Movie
import com.example.mdblove.utils.Logger
import java.util.*

class GridAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        Logger.verbose("did I create smt?", "who knows..")
        return MovieViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: Movie = movieList[position]
        holder.bind(movie)
    }

}

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.movie_grid_item, parent, false)) {
    private var imageView: ImageView? = null

    init {
        imageView = itemView.findViewById(R.id.movie_image)
    }

    fun bind(movie: Movie) {
        val rnd = Random();
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        imageView?.setBackgroundColor(color);
    }

}
