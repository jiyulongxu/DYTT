package com.bzh.dytt

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.Menu
import android.view.MenuItem
import com.bzh.dytt.base.BaseActivity
import com.bzh.dytt.base.BaseFragment
import com.bzh.dytt.ui.home.HomeFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, HasSupportFragmentInjector {
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        return false
    }

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var pagerAdapter: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

//        toolbar.setTitle(R.string.nav_home_page)
//        setSupportActionBar(toolbar)
//
//        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
//        drawer_layout.addDrawerListener(toggle)
//        toggle.syncState()
//
//        nav_view.setNavigationItemSelectedListener(this)
//
//        pagerAdapter = MainViewPagerAdapter(supportFragmentManager)
//        content_container.adapter = pagerAdapter
//
//        MobileAds.initialize(this, ADMOB_APP_ID)
    }

//    override fun onBackPressed() {
//        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
//            drawer_layout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_search) {
            SingleActivity.startSearchPage(this)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        val id = item.itemId
//
//        when (id) {
//            R.id.nav_home -> {
//                toolbar.setTitle(R.string.nav_home_page)
//                content_container.currentItem = 0
//            }
//        }
//
//        drawer_layout.closeDrawer(GravityCompat.START)
//
//        return true
//    }

    override fun supportFragmentInjector() = fragmentInjector

    class MainViewPagerAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): BaseFragment = when (position) {
            0 -> HomeFragment.newInstance()
            else -> throw IndexOutOfBoundsException()
        }

        override fun getCount() = 1
    }

    companion object {

        // ca-app-pub-2810447214027158/1355816417
        const val ADMOB_APP_ID_BZH = "ca-app-pub-2810447214027158~8679772669"

        const val ADMOB_APP_ID = "ca-app-pub-8112052667906046~4830848371"
    }
}