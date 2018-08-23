package com.ajithvgiri.muvies

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ajithvgiri.muvies.`interface`.FragmentInterface
import com.ajithvgiri.muvies.fragment.BrowseFragment
import com.ajithvgiri.muvies.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


/**
 * Created by ajithvgiri
 */
class MainActivity : AppCompatActivity(), FragmentInterface {

    var selectedItemId = R.id.navigation_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nestedScrollView.isSmoothScrollingEnabled = true
        commitFragment(HomeFragment(), false)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    /**
     * Bottom navigation listener
     */
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                textView_title.setText(R.string.app_name)
                if (selectedItemId != R.id.navigation_home || supportFragmentManager.findFragmentById(R.id.frameLayout) != HomeFragment()) {
                    popBackStackImmediate()
                    commitFragment(HomeFragment(), false)
                    selectedItemId = R.id.navigation_home
                    return@OnNavigationItemSelectedListener true
                } else {
                    scrollTop()
                }
            }
            R.id.navigation_browse -> {
                textView_title.setText(R.string.title_browse)
                if (selectedItemId != R.id.navigation_browse || supportFragmentManager.findFragmentById(R.id.frameLayout) != BrowseFragment()) {
                    popBackStackImmediate()
                    commitFragment(BrowseFragment(), false)
                    selectedItemId = R.id.navigation_browse
                    return@OnNavigationItemSelectedListener true
                } else {
                    scrollTop()
                }
            }
            R.id.navigation_saved -> {
//                textView_title.setText(R.string.title_saved)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_account -> {
//                textView_title.setText(R.string.title_account)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    /**
     * Scroll to top
     */
    override fun scrollTop() {
        ObjectAnimator.ofInt(nestedScrollView, "scrollY", 0, 0).setDuration(200).start()
    }

    /**
     * Interface methods
     */

    override fun showtoolBar() {
        appBarLayout.setExpanded(true, true)
    }

    override fun showprogressBar() {
        frameLayout.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideprogressBar() {
        frameLayout.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun toolbarTitle(title: String) {
        textView_title.text = title
    }

    override fun commitFragment(fragment: Fragment, isStack: Boolean) {
        // Begin the transaction
        val ft = supportFragmentManager.beginTransaction()
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.frameLayout, fragment)
        if (isStack) {
            ft.addToBackStack(fragment.tag)
        }
        // or ft.add(R.id.your_placeholder, new FooFragment());

        // Complete the changes added above
        ft.setCustomAnimations(R.anim.push_left_in, R.anim.hyperspace_out, R.anim.hyperspace_in, R.anim.push_left_out)
        ft.commit()
    }

    override fun commitFragment(fragment: Fragment, isStack: Boolean, view: View, transitionName: String) {
        val ft = supportFragmentManager
                .beginTransaction()
                .setReorderingAllowed(true)
                .addSharedElement(view, transitionName)
                .replace(R.id.frameLayout, fragment)
        if (isStack) {
            ft.addToBackStack(fragment.tag)
        }
        ft.commit()
    }

    fun popBackStackImmediate() {
        supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.push_left_in, R.anim.hyperspace_out, R.anim.hyperspace_in, R.anim.push_left_out)
        supportFragmentManager.popBackStackImmediate()
    }

    fun popBackStack() {
        supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.push_left_in, R.anim.hyperspace_out, R.anim.hyperspace_in, R.anim.push_left_out)
        supportFragmentManager.popBackStack()
    }
}