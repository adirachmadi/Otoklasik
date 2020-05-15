package com.example.basemvp.ui.activity.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basemvp.R
import com.example.basemvp.common.Fungsiku
import com.example.basemvp.common.base.BaseActivity
import com.example.basemvp.common.helper.ValidationHelper
import com.example.basemvp.ui.activity.dashboard.DashboardActivity
import com.example.basemvp.ui.activity.register.RegisterActivity
import com.example.bidder.sharedpreference.KeySharedPreference
import com.example.bidder.sharedpreference.SharedPreference
import com.example.bidder.sharedpreference.TokenDummy
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val TAG = "LoginActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val errorMessage = "Harap diisi terlebih dahulu!"
        ValidationHelper.isValidMaterialEditText(et_email_layout, et_username, errorMessage)
        ValidationHelper.isValidMaterialEditText(et_password_layout, et_password, errorMessage)

        onClickListener()
    }

    fun showErrorWrong() {
        Fungsiku.showPopUpDialogWaring(this, "Login gagal !", "Username atau password salah.")
    }

    fun showErrorEmpty() {
        Fungsiku.showPopUpDialogWaring(this, "Login gagal !", "Username atau password tidak boleh kosong.")
    }


    fun onSuccess() {
        val sharedPref = SharedPreference(applicationContext)
        sharedPref.save(KeySharedPreference.KEY_TOKEN, TokenDummy.TOKEN)
        Log.d(TAG, "$sharedPref")

        val intent = Intent(this, DashboardActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val sharedPreference = SharedPreference(this)
        sharedPreference.save("USERNAME", "")
        sharedPreference.save("EMAIL", "")
        startActivity(intent)
        finish()
    }

    fun onClickListener() {
        btn_go_daftar.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btn_login.setOnClickListener {
            val username = et_username.text.toString()
            val password  = et_password.text.toString()
            showProgressDialog()
            checkValidation(username, password)
        }
    }

    fun showProgressDialog() {
        Fungsiku.showProgressDialog(this, "Loading...")
    }

    fun dismissProgressDialog() {
        Fungsiku.dismissProgressDialog()
    }

    fun checkValidation(username : String, password: String) {
        //Field Validation
        if(username.isEmpty() || password.isEmpty()) {
            dismissProgressDialog()
            showErrorEmpty()
        }
        else if(username == "admin" && password == "otoklasik") {
            dismissProgressDialog()
            onSuccess()

        } else {
            Log.d(TAG, "cek username: $username, password: $password")
            dismissProgressDialog()
            showErrorWrong()
        }
    }


}
