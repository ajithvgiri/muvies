package com.ajithvgiri.muvies.fragment.child_fragments


import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import com.ajithvgiri.muvies.R
import com.ajithvgiri.muvies.`interface`.FragmentInterface
import com.ajithvgiri.muvies.adapter.GridVerticalBannerAdapter
import com.ajithvgiri.muvies.model.Movie
import com.ajithvgiri.muvies.utils.AppConstants
import kotlinx.android.synthetic.main.fragment_see_all.*


/**
 * Created by ajithvgiri
 */
class SeeAllFragment : Fragment() {

    private lateinit var fragmentInterface: FragmentInterface
    private val movieList = ArrayList<Movie>()


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (activity is FragmentInterface) {
            fragmentInterface = activity as FragmentInterface
        } else {
            // Throw an error!
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_see_all, container, false)
        (view?.parent as? ViewGroup)?.doOnPreDraw {
            // Parent has been drawn. Start transitioning!
            startPostponedEnterTransition()
        }
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)

        val movie = Movie(0, "")

        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)
        movieList.add(movie)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        fragmentInterface.showprogressBar()

//        loadAnimation()

        postponeEnterTransition()

        initView()
        // Data is loaded so lets wait for our parent to be drawn

    }


    private fun loadAnimation() {
        Handler().postDelayed({
            //Do something after 3000ms
            fragmentInterface.hideprogressBar()
            initView()
        }, AppConstants().instance.loadingTime)

    }


    private fun initView() {

        //Initial UI Changes
        fragmentInterface.scrollTop()
        fragmentInterface.showtoolBar()

        //GridLayoutManager
        val gridLayoutManager = GridLayoutManager(context, 2)

        //Adapter
        val moviesAdapter = GridVerticalBannerAdapter(movieList)

        recyclerView_seeAll.layoutManager = gridLayoutManager
        recyclerView_seeAll.adapter = moviesAdapter

        moviesAdapter.notifyDataSetChanged()
        postponeEnterTransition()

    }


}
