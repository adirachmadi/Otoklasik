package com.example.basemvp.ui.splash

import android.os.Handler
import android.util.Log
import com.example.basemvp.common.constant.AppConstants
import com.example.basemvp.common.helper.ValidationHelper
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by varcant on 21,April,2020
 * nanda.kista@gmail.com
 */
class SplashPresenter: SplashContract.Presenter {

    private val TAG = "SplashPresenter"

    private lateinit var view: SplashContract.View
    private val subscriptions = CompositeDisposable()

    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: SplashContract.View) {
        this.view = view
    }

    override fun initSplash(token : String?) {
        Handler().postDelayed({
                view.openHome()
        }, AppConstants.SPLASH_TIME_MILLISECOND)

        Log.d(TAG, "$token")
        Handler().postDelayed({
            //Check user token
            if (ValidationHelper.isEmpty(token))
                view.openLogin()
            else
                view.openHome()
        }, AppConstants.SPLASH_TIME_MILLISECOND)
    }

}