package com.example.basemvp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.basemvp.R
import com.example.basemvp.ui.activity.tambah_produk.TambahProdukActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_tambah_produk.*

/**
 * A simple [Fragment] subclass.
 */
class TambahProdukFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tambah_produk, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_tambah_produk.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()

            startActivity(Intent(activity, TambahProdukActivity::class.java))
        }
    }

}
