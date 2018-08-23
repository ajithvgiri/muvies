package com.ajithvgiri.muvies.fragment


import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajithvgiri.muvies.R
import com.ajithvgiri.muvies.`interface`.FragmentInterface
import com.ajithvgiri.muvies.adapter.HorizontalBannerAdapter
import com.ajithvgiri.muvies.adapter.VerticalBannerAdapter
import com.ajithvgiri.muvies.fragment.child_fragments.SeeAllFragment
import com.ajithvgiri.muvies.model.Movie
import com.ajithvgiri.muvies.utils.AppConstants
import com.ajithvgiri.muvies.utils.AppUtils
import kotlinx.android.synthetic.main.continue_watching_layout.*
import kotlinx.android.synthetic.main.recently_added_layout.*
import kotlinx.android.synthetic.main.trending_nearby_layout.*


/**
 * Created by ajithvgiri
 */
class HomeFragment : Fragment(), View.OnClickListener {

    lateinit var fragmentInterface: FragmentInterface
    val recentList = ArrayList<Movie>()
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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movie = Movie(0, "")
        recentList.add(movie)
        recentList.add(movie)
        recentList.add(movie)
        recentList.add(movie)
        recentList.add(movie)
        recentList.add(movie)
        recentList.add(movie)
        recentList.add(movie)
        recentList.add(movie)
        recentList.add(movie)
        recentList.add(movie)

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

        textView_seeAll_trending.setOnClickListener(this)
        textView_seeAll_watching.setOnClickListener(this)

        recyclerViewUI()

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.textView_seeAll_watching -> {
                fragmentInterface.commitFragment(SeeAllFragment(), true, textView_seeAll_watching, ViewCompat.getTransitionName(textView_seeAll_watching)!!)
                AppUtils().instance.showToast(activity!!.applicationContext, "Watching")
            }
            R.id.textView_seeAll_trending -> {
                AppUtils().instance.showToast(activity!!.applicationContext, "Trending")
            }
            else -> {

            }
        }
    }


    /**
     * RecyclerView UI
     */
    fun recyclerViewUI() {

        //LinearLayoutManager
        val linearLayoutManager1 = LinearLayoutManager(context)
        val linearLayoutManager2 = LinearLayoutManager(context)
        val linearLayoutManager3 = LinearLayoutManager(context)

        //LinearLayoutManager.orientation
        linearLayoutManager1.orientation = LinearLayoutManager.HORIZONTAL
        linearLayoutManager2.orientation = LinearLayoutManager.HORIZONTAL
        linearLayoutManager3.orientation = LinearLayoutManager.HORIZONTAL

        //Adapter
        val recentAdapter = HorizontalBannerAdapter(recentList)
        val watchingAdapter = VerticalBannerAdapter(watchingList)
        val tredingAdapter = VerticalBannerAdapter(watchingList)


        recyclerView_recentlyAdded.layoutManager = linearLayoutManager1
        recyclerView_recentlyAdded.adapter = recentAdapter

        recyclerView_continueWatching.layoutManager = linearLayoutManager2
        recyclerView_continueWatching.adapter = watchingAdapter

        recyclerView_trendingNearby.layoutManager = linearLayoutManager3
        recyclerView_trendingNearby.adapter = tredingAdapter

        recentAdapter.notifyDataSetChanged()
        watchingAdapter.notifyDataSetChanged()
        tredingAdapter.notifyDataSetChanged()
    }
}
