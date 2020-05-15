package com.example.basemvp.ui.activity.detail_barang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.basemvp.R
import kotlinx.android.synthetic.main.activity_detail_barang.*

class DetailBarangActivity : AppCompatActivity() {

    companion object {
        val EXTRA_NAMA = "nama_barang"
        val EXTRA_PHOTO = "photo_barang"
        val EXTRA_HARGA = "harga_barang"
        val EXTRA_DESKRIPSI = "deskripsi_barang"
        val EXTRA_TANGGAL = "tgl_barang"
        val EXTRA_LOKASI = "lokasi_barang"
        val EXTRA_PENYELENGGARA = "penyelenggara_barang"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_barang)

        //TOOLBAR
        setSupportActionBar(tb_detail_lelang)
        supportActionBar?.title = "Detail Barang"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getDetail()
        onSwipeRefresh()

        btn_hubungi_penjual.setOnClickListener {
            Toast.makeText(this, "Menghubungi Pembeli", Toast.LENGTH_LONG).show()
        }
    }

    fun onSwipeRefresh() { sr_detail_barang.setOnClickListener {
        onLoading(true)
        getDetail()
        Handler().postDelayed({ sr_detail_barang.isRefreshing = false }, 500)
        }
    }

    fun onLoading(state: Boolean) {
        if (state) {
            pb_detail_barang.visibility = VISIBLE
            pb_photo_detail.visibility= VISIBLE
        } else
            pb_detail_barang.visibility = GONE
            pb_photo_detail.visibility= GONE
    }

    fun getDetail() {
        showDetail()
        onLoading(false)
    }

    fun showDetail() {
        val photo = intent.getStringExtra(EXTRA_PHOTO)

        tv_detail_judul_barang.text = intent.getStringExtra(EXTRA_NAMA)
        tv_detail_harga_barang.text = intent.getStringExtra(EXTRA_HARGA)
        tv_detail_lokasi.text = intent.getStringExtra(EXTRA_LOKASI)


        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(photo))
        imageList.add(SlideModel("https://lh3.googleusercontent.com/proxy/7hgOVcGkdqCD5DT3IjwAt-8Reh68DMNsQ4zpq4kgnUHab8J_qbBVq3p1HKqQzflxnQHY4xl_sYjr9-LTzToCB1uDrEP_jpPvOeyL2HOHoJn77MFW2sKkZWnWEylaXjkhSiOVBrcMwsiAmP7DkeyVOclLgw6-C1il", "Otoklasik",
            true))
        imageList.add(SlideModel("https://i.ytimg.com/vi/F86gnVO0QQg/maxresdefault.jpg", "Otoklasik"))
        val imageSlider = findViewById<ImageSlider>(R.id.iv_detail_photo)
        imageSlider.setImageList(imageList)
    }
}
