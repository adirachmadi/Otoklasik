package com.example.basemvp.ui.activity.pengaturan.reset_password

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.example.basemvp.R
import com.example.basemvp.common.Fungsiku
import com.example.basemvp.common.base.BaseActivity
import com.example.basemvp.common.helper.ValidationHelper
import kotlinx.android.synthetic.main.activity_ubah_password.*
import kotlinx.android.synthetic.main.item_popup_success.*

class UbahPasswordActivity : BaseActivity(), UbahPasswordContract.View {
    val TAG = "UbahPasswordActivity"
    val presenter = UbahPasswordPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_password)

        presenter.attach(this)

        //Toolbar
        setSupportActionBar(tb_ubah_password)
        supportActionBar?.title = "Ubah Password"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onInit() {
        initView()
    }

    override fun initView() {val errorMessage = "Harap diisi terlebih dahulu!"
        ValidationHelper.isValidMaterialEditText(et_ubah_password_old_password_layout, et_ubah_password_old_password, errorMessage)
        ValidationHelper.isValidMaterialEditText(et_ubah_password_new_password_layout, et_ubah_password_new_password, errorMessage)
        ValidationHelper.isValidMaterialEditText(et_ubah_password_confirm_password_layout, et_ubah_password_confirm_password, errorMessage)

        btn_ubah_password_save.setOnClickListener {
            val oldPassword = et_ubah_password_old_password.text.toString()
            val newPassword  = et_ubah_password_new_password.text.toString()
            val confirmPassword = et_ubah_password_confirm_password.text.toString()
            showProgressDialog()
            presenter.checkValidation(oldPassword, newPassword, confirmPassword)
        }
    }

    override fun showErrorEmpty() {
        Fungsiku.showPopUpDialogWaring(this, "Registrasi gagal !", "Semua field harus diisi.")
    }

    override fun onSuccess() {
        showPopUp()
    }

    override fun confirmPassword() {
        et_ubah_password_confirm_password_layout.error = "Password tidak cocok"
    }

    override fun showProgressDialog() {
        Fungsiku.showProgressDialog(this, "Loading...")
    }

    override fun dismissProgressDialog() {
        Fungsiku.dismissProgressDialog()
    }

    override fun validPassword() {
        et_ubah_password_new_password_layout.error = "Password minimal terdiri dari 5 karakter"
    }

    override fun showPopUp() {
        val epicDialog = Dialog(this)
        epicDialog.setContentView(R.layout.item_popup_success)
        epicDialog.tv_popup_title.text = "Berhasil"
        epicDialog.tv_popup_message.text = "Selamat password Anda berhasil diubah!"
        epicDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        epicDialog.show()
        epicDialog.setCanceledOnTouchOutside(false)

        epicDialog.btn_ok_regis.setOnClickListener {
            epicDialog.dismiss()
            //val intent = Intent(this, DashboardActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
