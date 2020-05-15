package com.example.basemvp.ui.splash

import com.example.basemvp.common.base.BaseContract

/**
 * Created by varcant on 21,April,2020
 * nanda.kista@gmail.com
 */
class SplashContract {

    interface View : BaseContract.View {
        fun initPermission()

        //fun getToketn(token: String?)

        fun openHome()

        fun openLogin()

        fun showPermissionDialog()
    }

    //@PreActivity
    interface Presenter : BaseContract.Presenter<View> {

        fun initSplash(token: String?)

    }

}