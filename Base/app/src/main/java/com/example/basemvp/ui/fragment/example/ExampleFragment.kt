package com.example.basemvp.ui.fragment.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basemvp.R
import com.example.basemvp.common.base.BaseFragment
import com.example.basemvp.model.Barang
import com.example.bidder.ui.fragment.aktivitas.ExampleFragmentPresenter

class ExampleFragment : BaseFragment(),
    ExampleFragmentContract.View {

    var presenter = ExampleFragmentPresenter()
    private var listBarang: ArrayList<Barang> = arrayListOf()

    override lateinit var rootView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_example, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()

//        showRecyclerList(listBarang)
//        listBarang.addAll(AktivitasData.listBarang)

    }


    override fun onInit() {
        initView()
    }

    override fun initView() {
//        rv_aktivitas.setHasFixedSize(true)
//        //Menu ActionBar
//        btn_riwayat.setOnClickListener {
//            startActivity(Intent(activity, RiwayatActivity::class.java))
//        }
    }

    override fun showRecyclerList(list: ArrayList<Barang>) {
        presenter.onLoading(false)
    }


    override fun progressBarShow() {
//        pb_aktivitas.visibility = View.VISIBLE
    }

    override fun progressBarHide() {
//        pb_aktivitas.visibility = View.GONE
    }

}