package com.alangaelrojas.mymovies.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.alangaelrojas.mymovies.R
import com.alangaelrojas.mymovies.model.ItemMovie
import com.alangaelrojas.mymovies.sys.loadImage

class MoviesAdapter(
    private val onMovieItemClick: OnMovieItemClick,
    private val context: Context
) : RecyclerView.Adapter<MoviesAdapter.HolderMovie>() {

    private val movieList = ArrayList<ItemMovie>()

    fun addMovies(movies: List<ItemMovie>){
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderMovie {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return HolderMovie(inflater)
    }

    override fun onBindViewHolder(holder: HolderMovie, position: Int) {
        val movie: ItemMovie = movieList[position]
        holder.setMovie(movie)
    }

    override fun getItemCount(): Int = movieList.size

    inner class HolderMovie(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var poster: ImageView
        private var title: TextView
        private var overview: TextView
        private var rate: TextView
        private var movieCard: CardView

        init {
            poster = itemView.findViewById(R.id.cover)
            title = itemView.findViewById(R.id.title)
            overview = itemView.findViewById(R.id.description)
            rate = itemView.findViewById(R.id.average)
            movieCard = itemView.findViewById(R.id.movieCard)
        }

        fun setMovie(movie: ItemMovie){
            poster.loadImage(movie.movieCover, context)
            title.text = movie.movieTitle
            overview.text = movie.description
            rate.text = movie.voteAverage.toString()

            movieCard.setOnClickListener {
                onMovieItemClick.onMovieItemClicked(movie)
            }
        }

    }

}