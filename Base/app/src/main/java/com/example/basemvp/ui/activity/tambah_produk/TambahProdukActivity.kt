package com.example.basemvp.ui.activity.tambah_produk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basemvp.R
import com.example.basemvp.common.Fungsiku
import com.example.basemvp.common.Fungsiku.showProgressDialog
import com.example.basemvp.common.helper.ValidationHelper
import com.example.basemvp.ui.activity.dashboard.DashboardActivity
import kotlinx.android.synthetic.main.activity_tambah_produk.*
import kotlinx.android.synthetic.main.fragment_tambah_produk.*

class TambahProdukActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_produk)

        setSupportActionBar(tb_tambah_produk)
        supportActionBar?.title = "Tambah Produk"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val errorMessage = "Harap diisi terlebih dahulu!"
        ValidationHelper.isValidMaterialEditText(et_judul_layout, et_judul, errorMessage)
        ValidationHelper.isValidMaterialEditText(et_harga_layout, et_harga, errorMessage)
        ValidationHelper.isValidMaterialEditText(et_deskripsi_layout, et_deskripsi, errorMessage)

        btn_tambah_produk_validasi.setOnClickListener {
            val judul = et_judul.text.toString()
            val harga  = et_harga.text.toString()
            val deskripsi = et_deskripsi.text.toString()
            checkValidation(judul, harga, deskripsi)
        }

    }

    private fun checkValidation(judul: String, harga: String, deskripsi: String) {
        //Field Validation
        if(judul.isEmpty() || harga.isEmpty() || deskripsi.isEmpty()) {
            showErrorEmpty() }
        else {
            Fungsiku.showPopUpDialog(this, "Berhasil", "Berhasil menambahkan barang")
            startActivity(Intent(this, DashboardActivity::class.java))
        }
    }

    private fun showErrorEmpty() {
        Fungsiku.showPopUpDialogWaring(this, "Gagal !", "Semua field harus diisi.")
    }
}
