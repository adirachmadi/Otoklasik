package com.example.basemvp.ui.activity.pengaturan.reset_password

import com.example.basemvp.common.helper.ValidationHelper
import io.reactivex.disposables.CompositeDisposable

class UbahPasswordPresenter : UbahPasswordContract.Presenter {
    private val TAG = "UbahPasswordPresenter"

    private lateinit var view: UbahPasswordContract.View
    private val subscriptions = CompositeDisposable()

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: UbahPasswordContract.View) {
        this.view = view
    }

    override fun checkValidation(passwordLama: String, passwordBaru: String, repassword : String) {

        //Field Validation
        if(passwordLama.isEmpty() || passwordBaru.isEmpty() || repassword.isEmpty()) {
            view.dismissProgressDialog()
            view.showErrorEmpty()
        } else if(!ValidationHelper.isValidPassword(passwordBaru)) {
            view.validPassword()
            view.dismissProgressDialog()
        } else if (passwordBaru != repassword) {
            view.confirmPassword()
            view.dismissProgressDialog()
        } else {
            view.dismissProgressDialog()
            view.onSuccess()
        }
    }

}