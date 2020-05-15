package com.example.basemvp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel

import com.example.basemvp.R
import com.example.basemvp.adapter.BarangAdapter
import com.example.basemvp.dummy.DataBarang
import com.example.basemvp.model.Barang
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.fragment_beranda.*

/**
 * A simple [Fragment] subclass.
 */
class BerandaFragment : Fragment() {

    val imageList = ArrayList<SlideModel>()
    private var listBarang: ArrayList<Barang> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        imageList.add(SlideModel("https://imgx.gridoto.com/crop/0x0:1280x640/700x465/filters:watermark(file/2017/gridoto/img/watermark_otomotifnet.png,5,5,60)/photo/2020/01/10/1914736123.jpeg",
            true))
        imageList.add(SlideModel("https://i2.wp.com/zonabikers.com/wp-content/uploads/2016/03/Honda-C700-1981-12.png?fit=800%2C533&ssl=1"))
        imageList.add(SlideModel("https://imgx.motorplus-online.com/crop/0x0:0x0/700x465/photo/2019/06/16/4235485164.jpg"))
        //imageList.add(SlideModel("https://3.bp.blogspot.com/-uJtCbNrBzEc/XJUWQPOSrfI/AAAAAAAABUs/ZlReSwpfI3Ack60629Rv0N8hSrPFHb3TACLcBGAs/s1600/elephant.jpg", "The population of elephants is decreasing in the world."))

    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showRecyclerList(listBarang)
        listBarang.addAll(DataBarang.listBarang)
        rv_list_barang.setHasFixedSize(true)

      val imageSlider = view.findViewById<ImageSlider>(R.id.slider_dashboard)
        Log.d("DASHBOARD ", imageList.toString())
        slider_dashboard.setImageList(imageList)
        //imageSlider.setImageList(imageList)
    }

    fun showRecyclerList(list: ArrayList<Barang>) {
        val listLelangSmartphone = BarangAdapter(list)
        rv_list_barang.layoutManager = GridLayoutManager(activity, 2)
        rv_list_barang.adapter = listLelangSmartphone
        onLoading(false)
    }

    fun onLoading(state : Boolean) {
        if (state) {
            pb_beranda.visibility = VISIBLE
        } else {
            pb_beranda.visibility = INVISIBLE
        }
    }

}
