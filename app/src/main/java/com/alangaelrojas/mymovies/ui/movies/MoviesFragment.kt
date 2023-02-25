package com.alangaelrojas.mymovies.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.alangaelrojas.mymovies.R
import com.alangaelrojas.mymovies.domain.MoviesViewModel

class MoviesFragment : Fragment() {


    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]

        viewModel.movieList.observe(viewLifecycleOwner){ movies ->
            Toast.makeText(context, movies.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.getMovies()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            MoviesFragment().apply {}
    }
}