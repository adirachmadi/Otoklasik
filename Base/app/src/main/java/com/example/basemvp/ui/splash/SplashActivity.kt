package com.example.basemvp.ui.splash

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.basemvp.R
import com.example.basemvp.common.base.BaseActivity
import com.example.basemvp.common.constant.AppConstants
import com.example.basemvp.common.helper.PermissionHelper
import com.example.basemvp.ui.activity.dashboard.DashboardActivity
import com.example.bidder.sharedpreference.KeySharedPreference
import com.example.bidder.sharedpreference.SharedPreference
import com.example.basemvp.ui.activity.login.LoginActivity


class SplashActivity : BaseActivity(), SplashContract.View {

    private val TAG = "SplashActivity"

    val presenter = SplashPresenter()

    private lateinit var permissionHelper: PermissionHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //activityComponent.inject(this)
        setContentView(R.layout.activity_splash)
        presenter.attach(this)

        if (Build.VERSION.SDK_INT >= 21) {
            //window.navigationBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark); // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary); //status bar or the time bar at the top
        }
    }


    override fun onInit() {
        initPermission()

        //Get Token from SharedPreference
        val sharedPref = SharedPreference(applicationContext)
        val token = sharedPref.getValueString(KeySharedPreference.KEY_TOKEN)
        Log.d(TAG, "token : $token")
        presenter.initSplash(token)
    }

    override fun initPermission() {
        permissionHelper = PermissionHelper.Builder(this)
            .withPermissions(
                Manifest.permission.CAMERA,
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.RECEIVE_BOOT_COMPLETED
            )
            .withRequestCode(AppConstants.REQUEST_CODE_PERMISSION)
            .withListener(object : PermissionHelper.OnPermissionCheckedListener {
                override fun onPermissionGranted(isPermissionAlreadyGranted: Boolean) {
                    //Get Token from SharedPreference
                    val sharedPref = SharedPreference(applicationContext)
                    val token = sharedPref.getValueString(KeySharedPreference.KEY_TOKEN)
                    presenter.initSplash(token)
                }

                override fun onPermissionDenied() {
                    showPermissionDialog()
                }
            })
            .build()

        permissionHelper.requestPermission()
    }

//    override fun getToketn(token: String?) {
//        val sharedPref = SharedPreference(applicationContext)
//        val token = sharedPref.getValueString(KeySharedPreference.KEY_TOKEN)
//    }

    override fun showPermissionDialog() {
//        AlertDialog.Builder(this, R.style.AppTheme)
//            .setTitle(R.string.label_warning)
//            .setCancelable(false)
//            .setMessage(R.string.label_message_apps_requirement)
//            .setPositiveButton(R.string.label_show_permission) { dialog, which ->
//                dialog.dismiss()
//                initPermission()
//            }
//            .setNegativeButton(R.string.label_close_app) { dialog, which ->
//                dialog.dismiss()
//                finish()
//            }
//            .show()
    }

    override fun openHome() {
        startActivityWithFade(DashboardActivity::class.java)
        finish()
    }

    override fun openLogin() {
        Log.d(TAG, "openLogin")

        val intent = Intent(this, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startIntentActivityWithFade(intent)
        finish()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        //Permissions result handler
        permissionHelper.onRequestPermissionsResult(
            AppConstants.REQUEST_CODE_PERMISSION,
            null,
            null
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }
}

