package com.ajithvgiri.muvies.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.ajithvgiri.muvies.R
import com.ajithvgiri.muvies.model.Movie

/**
 * Created by ajithvgiri
 */
class VerticalBannerAdapter(private var movies: List<Movie>) : RecyclerView.Adapter<VerticalBannerAdapter.ViewHolder>() {
    internal var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.vertical_banner_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (position) {
            0 -> {
                holder.linearLayout.setPadding(70, 0, 0, 0)
            }
            movies.size - 1 -> {
                holder.linearLayout.setPadding(15, 0, 70, 0)
            }
            else -> {
                holder.linearLayout.setPadding(15, 0, 0, 0)
            }
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var linearLayout: LinearLayout = itemView.findViewById<View>(R.id.linearLayout) as LinearLayout
    }


}