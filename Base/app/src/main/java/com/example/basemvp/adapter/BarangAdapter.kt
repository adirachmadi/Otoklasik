package com.example.basemvp.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.basemvp.R
import com.example.basemvp.model.Barang
import com.example.basemvp.ui.activity.detail_barang.DetailBarangActivity

class BarangAdapter(private val listBarang : ArrayList<Barang>) :
    RecyclerView.Adapter<BarangAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNama : TextView = itemView.findViewById(R.id.tv_judul_barang)
        var tvHarga : TextView = itemView.findViewById(R.id.tv_harga_barang)
        var tvLokasi : TextView = itemView.findViewById(R.id.tv_lokasi_barang)
        var imgPhoto : ImageView = itemView.findViewById(R.id.img_photo_barang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_barang, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBarang.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val dataBarang = listBarang[position]
        holder.tvNama.text = dataBarang.nama
        holder.tvHarga.text = dataBarang.harga
        holder.tvLokasi.text = dataBarang.lokasi

            Glide.with(holder.itemView.context)
                .load(dataBarang.photo)
                .error(R.drawable.img_error_gambar)
                .apply(RequestOptions().override(350, 450))
                .into(holder.imgPhoto)
            Log.d("IMAGE :", dataBarang.photo)


        holder.itemView.setOnClickListener {
            val context = it.context
            val intent = Intent(context, DetailBarangActivity::class.java)
            intent.putExtra(DetailBarangActivity.EXTRA_NAMA, dataBarang.nama)
            intent.putExtra(DetailBarangActivity.EXTRA_HARGA, dataBarang.harga)
            intent.putExtra(DetailBarangActivity.EXTRA_LOKASI, dataBarang.lokasi)
            intent.putExtra(DetailBarangActivity.EXTRA_TANGGAL, dataBarang.tanggal)
            intent.putExtra(DetailBarangActivity.EXTRA_PHOTO, dataBarang.photo)
            context.startActivity(intent)
        }

    }
}