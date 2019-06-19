package com.example.mdblove

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mdblove.data.Movie
import com.example.mdblove.utils.Logger
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment() {

    private val movieList = listOf(
        Movie("Raising Arizona", 1987),
        Movie("Vampire's Kiss", 1988),
        Movie("Con Air", 1997),
        Movie("Gone in 60 Seconds", 1997),
        Movie("National Treasure", 2004),
        Movie("The Wicker Man", 2006),
        Movie("Ghost Rider", 2007),
        Movie("Knowing", 2009)
    )


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    // populate the views now that the layout has been inflated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.verbose("Hiii",">>>>>>.")
        // RecyclerView node initialized here
        grid_recycler_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 2)
            // set the custom adapter to the RecyclerView
            Logger.verbose("Hiii",">>>>>>.")
            adapter = GridAdapter(movieList)
        }
    }

    companion object {
        fun newInstance(): MoviesFragment = MoviesFragment()
    }

}