package com.example.basemvp.ui.activity.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.basemvp.R
import com.example.basemvp.common.Fungsiku
import com.example.basemvp.ui.fragment.ProfileFragment
import com.example.basemvp.ui.fragment.AboutUsFragment
import com.example.basemvp.ui.fragment.BerandaFragment
import com.example.basemvp.ui.fragment.TambahProdukFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        //BOTTOM NAVBAR
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        //BOTTOM NAVBAR ON  CLICK
        if (savedInstanceState == null) {
            navigation.selectedItemId = R.id.navigation_beranda
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }


    //BottomNavigationBar
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val fragment: Fragment
            when (item.itemId) {
                R.id.navigation_beranda -> {
                    fragment = BerandaFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.container_layout,
                            fragment,
                            fragment.javaClass.simpleName
                        )
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_tambah_produk -> {
                    fragment = TambahProdukFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.container_layout,
                            fragment,
                            fragment.javaClass.simpleName
                        )
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_about_us -> {
                    fragment = AboutUsFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.container_layout,
                            fragment,
                            fragment.javaClass.simpleName
                        )
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    fragment = ProfileFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.container_layout,
                            fragment,
                            fragment.javaClass.simpleName
                        )
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    //Double Back Press for Exit
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
}
