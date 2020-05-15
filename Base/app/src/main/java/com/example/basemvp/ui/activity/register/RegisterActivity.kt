package com.example.basemvp.ui.activity.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.basemvp.R
import com.example.basemvp.common.Fungsiku
import com.example.basemvp.common.Fungsiku.showProgressDialog
import com.example.basemvp.common.helper.ValidationHelper
import com.example.basemvp.ui.activity.dashboard.DashboardActivity
import com.example.basemvp.ui.activity.login.LoginActivity
import com.example.bidder.sharedpreference.KeySharedPreference
import com.example.bidder.sharedpreference.SharedPreference
import com.example.bidder.sharedpreference.TokenDummy
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val TAG = "RegisterActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Toolbar
        setSupportActionBar(tb_daftar)
        supportActionBar?.title = "Registrasi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val errorMessage = "Harap diisi terlebih dahulu!"
        ValidationHelper.isValidMaterialEditText(et_regis_email_layout, et_regis_username, errorMessage)
        ValidationHelper.isValidMaterialEditText(et_regis_password_layout, et_regis_password, errorMessage)
        ValidationHelper.isValidMaterialEditText(et_regis_email_layout, et_regis_email, errorMessage)
        ValidationHelper.isValidMaterialEditText(et_regis_konfirmasi_password_layout, et_regis_konfirmasi_password, errorMessage)

        btn_daftar.setOnClickListener {
            val username = et_regis_username.text.toString()
            val password  = et_regis_password.text.toString()
            val konfirm = et_regis_konfirmasi_password.text.toString()
            val email = et_regis_email.text.toString()
            Log.d(TAG, email)
            showProgressDialog()
            checkValidation(username, password, email, konfirm)
            val sharedPreference = SharedPreference(this)
            sharedPreference.save("USERNAME", username)
            sharedPreference.save("EMAIL", email)
        }

        btn_go_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun checkValidation(username: String, password: String, email : String, repassword : String) {

        //Field Validation
        if(username.isEmpty() || password.isEmpty() || email.isEmpty() || repassword.isEmpty()) {
            dismissProgressDialog()
            showErrorEmpty()
        } else if(!ValidationHelper.isValidPassword(password)) {
            validPassword()
            dismissProgressDialog()
        } else if (password != repassword) {
            confirmPassword()
            dismissProgressDialog()
        } else if (!ValidationHelper.isValidEmail(email)) {
            validEmail()
            dismissProgressDialog()
        }
        else {
            dismissProgressDialog()
            onSuccess()
        }
    }

    private fun showErrorEmpty() {
        Fungsiku.showPopUpDialogWaring(this, "Registrasi gagal !", "Semua field harus diisi.")
    }

    private fun onSuccess() {
        val sharedPref = SharedPreference(applicationContext)
        sharedPref.save(KeySharedPreference.KEY_TOKEN, TokenDummy.TOKEN)
        Log.d(TAG, "$sharedPref")
//        Fungsiku.showPopUpDialog(this, "Berhasil", "Registrasi berhasil dilakukan")
        val intent = Intent(this, DashboardActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }

    private fun confirmPassword() {
        et_regis_konfirmasi_password_layout.error = "Password tidak cocok"
    }

    private fun showProgressDialog() {
        Fungsiku.showProgressDialog(this, "Loading...")
    }

    private fun dismissProgressDialog() {
        Fungsiku.dismissProgressDialog()
    }

    private fun validEmail() {
        et_regis_email_layout.error = "Email tidak valid!"
    }

    private fun validPassword() {
        et_regis_password_layout.error = "Password minimal terdiri dari 5 karakter"
    }
}
