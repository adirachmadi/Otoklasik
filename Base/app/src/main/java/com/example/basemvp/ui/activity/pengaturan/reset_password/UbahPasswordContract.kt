package com.example.basemvp.ui.activity.pengaturan.reset_password

import com.example.basemvp.common.base.BaseContract

class UbahPasswordContract {

    interface View : BaseContract.View {
        fun initView()
        fun showErrorEmpty()
        fun onSuccess()
        fun confirmPassword()
        fun showProgressDialog()
        fun dismissProgressDialog()
        fun validPassword()
        fun showPopUp()

    }

    interface Presenter : BaseContract.Presenter<View> {
        fun checkValidation(passwordLama: String, passwordBaru: String, repassword : String)
    }
}