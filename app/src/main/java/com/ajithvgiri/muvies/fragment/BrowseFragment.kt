package com.ajithvgiri.muvies.fragment


import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajithvgiri.muvies.R
import com.ajithvgiri.muvies.`interface`.FragmentInterface
import com.ajithvgiri.muvies.adapter.VerticalBannerAdapter
import com.ajithvgiri.muvies.model.Movie
import com.ajithvgiri.muvies.utils.AppConstants


/**
 * Created by ajithvgiri
 */
class BrowseFragment : Fragment() {

    lateinit var fragmentInterface: FragmentInterface
    val watchingList = ArrayList<Movie>()
    val trendingList = ArrayList<Movie>()


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
        return inflater.inflate(R.layout.fragment_browse, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movie = Movie(0, "")

        watchingList.add(movie)
        watchingList.add(movie)
        watchingList.add(movie)
        watchingList.add(movie)
        watchingList.add(movie)
        watchingList.add(movie)
        watchingList.add(movie)
        watchingList.add(movie)
        watchingList.add(movie)
        watchingList.add(movie)


        trendingList.add(movie)
        trendingList.add(movie)
        trendingList.add(movie)
        trendingList.add(movie)
        trendingList.add(movie)
        trendingList.add(movie)
        trendingList.add(movie)
        trendingList.add(movie)
        trendingList.add(movie)
        trendingList.add(movie)
        trendingList.add(movie)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        fragmentInterface.showprogressBar()

//        loadAnimation()
        initView()
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

        //LinearLayoutManager
        val linearLayoutManager2 = LinearLayoutManager(context)
        val linearLayoutManager3 = LinearLayoutManager(context)

        //LinearLayoutManager.orientation
        linearLayoutManager2.orientation = LinearLayoutManager.HORIZONTAL
        linearLayoutManager3.orientation = LinearLayoutManager.HORIZONTAL

        //Adapter
        val watchingAdapter = VerticalBannerAdapter(watchingList)
        val tredingAdapter = VerticalBannerAdapter(watchingList)




//        Recler.layoutManager = linearLayoutManager2
//        recyclerView_continueWatching.adapter = watchingAdapter
//
//        recyclerView_trendingNearby.layoutManager = linearLayoutManager3
//        recyclerView_trendingNearby.adapter = tredingAdapter

        watchingAdapter.notifyDataSetChanged()
        tredingAdapter.notifyDataSetChanged()
    }


}
