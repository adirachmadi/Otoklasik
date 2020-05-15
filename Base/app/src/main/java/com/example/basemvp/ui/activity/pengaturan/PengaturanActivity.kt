package com.example.bidder.ui.activity.pengaturan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.basemvp.R
import com.example.bidder.sharedpreference.SharedPreference
import com.example.basemvp.ui.activity.login.LoginActivity
import com.example.basemvp.ui.activity.pengaturan.reset_password.UbahPasswordActivity
import kotlinx.android.synthetic.main.activity_pengaturan.*

class PengaturanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengaturan)

        //TOOLBAR
        setSupportActionBar(tb_pengaturan)
        supportActionBar?.title = "Pengaturan"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btn_edit_profile.setOnClickListener {
            Toast.makeText(this, "Coming Soon Fitur !", Toast.LENGTH_LONG).show()
        }

        btn_logout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            val sharedPref = SharedPreference(applicationContext)
            sharedPref.clearSharedPreference()
            startActivity(intent)
            finish()
        }

        btn_ubah_password.setOnClickListener {
            startActivity(Intent(this, UbahPasswordActivity::class.java))
        }
    }
}
