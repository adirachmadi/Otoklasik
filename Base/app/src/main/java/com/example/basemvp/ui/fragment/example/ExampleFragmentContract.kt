package com.example.basemvp.ui.fragment.example

import com.example.basemvp.common.base.BaseContract
import com.example.basemvp.model.Barang

class ExampleFragmentContract {
    interface View : BaseContract.View {
        fun initView()

        fun showRecyclerList(list : ArrayList<Barang>)
        fun progressBarShow()
        fun progressBarHide()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onLoading(state:Boolean)
        fun getListBarang()
    }
}