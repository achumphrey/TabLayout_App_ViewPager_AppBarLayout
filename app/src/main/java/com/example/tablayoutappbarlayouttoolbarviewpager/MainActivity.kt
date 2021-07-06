@file:Suppress("DEPRECATION")

package com.example.tablayoutappbarlayouttoolbarviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create the object of Toolbar, ViewPager and
        // TabLayout and use “findViewById()” method*/
        val tab_toolbar = findViewById<Toolbar>(R.id.toolbar)
        val tab_viewpager = findViewById<ViewPager>(R.id.tab_viewpager)
        val tab_tablayout = findViewById<TabLayout>(R.id.tab_tablayout)

        // As we set NoActionBar as theme to this activity
        // so when we run this project, this activity will not
        // show title. And for this reason, we need to run
        // setSupportActionBar method so the title will show.
        setSupportActionBar(tab_toolbar)
        setupViewPager(tab_viewpager)

        // If we dont use setupWithViewPager() method then the
        // tabs will not be used or shown when activity is opened
        tab_tablayout.setupWithViewPager(tab_viewpager)
    }

    // This function is used to add items in ArrayList and assign
    // the adapter to view pager
    private fun setupViewPager(viewpager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // LoginFragment is the name of Fragment and the Login
        // is a title of tab
        adapter.addFragment(LoginFragment(), "Login")
        adapter.addFragment(SignupFragment(), "SignUp")

        // setting adapter to view pager.
        viewpager.adapter = adapter
    }

    // This "ViewPagerAdapter" class overrides functions which are
    // necessary to get information about which item is selected
    // by user, what is title for selected item and so on.*/
    class ViewPagerAdapter(supportFragmentManager: FragmentManager) :
        FragmentPagerAdapter(supportFragmentManager) {

        // objects of ArrayList. One is of Fragment type and
        // another one is of String type.*/
        private var fragmentObjectList: ArrayList<Fragment> = ArrayList()
        private var fragmentTitleList: ArrayList<String> = ArrayList()

        // returns which item is selected from ArrayList of fragments.
        override fun getItem(position: Int): Fragment {
            return fragmentObjectList.get(position)
        }

        // returns which item is selected from ArrayList of titles.
        @Nullable
        override fun getPageTitle(position: Int): CharSequence {
            return fragmentTitleList.get(position)
        }

        // returns the number of items present in ArrayList.
        override fun getCount(): Int {
            return fragmentObjectList.size
        }

        // this function adds the fragment and title in 2 separate  ArrayList.
        fun addFragment(fragment: Fragment, title: String) {
            fragmentObjectList.add(fragment)
            fragmentTitleList.add(title)
        }
    }
}