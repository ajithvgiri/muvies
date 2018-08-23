package com.ajithvgiri.muvies.`interface`

import android.support.v4.app.Fragment
import android.view.View

interface FragmentInterface {

    fun showprogressBar()

    fun hideprogressBar()

    fun showtoolBar()

    fun toolbarTitle(title: String)

    fun scrollTop()

    fun commitFragment(fragment: Fragment, isStack: Boolean)

    fun commitFragment(fragment: Fragment, isStack: Boolean, view: View, transitionName: String)

}