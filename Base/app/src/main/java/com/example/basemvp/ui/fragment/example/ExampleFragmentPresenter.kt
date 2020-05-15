package com.example.bidder.ui.fragment.aktivitas

import com.example.basemvp.ui.fragment.example.ExampleFragmentContract
import io.reactivex.disposables.CompositeDisposable

class ExampleFragmentPresenter : ExampleFragmentContract.Presenter {


    private val TAG = "ListPresenter"

    private lateinit var view: ExampleFragmentContract.View
    private val subscriptions = CompositeDisposable()

    override fun onLoading(state: Boolean) {
        if (state) {
            view.progressBarShow()
        } else
            view.progressBarHide()
    }

    override fun getListBarang() {
       // view.showRecyclerList()
        // view.progressBarHide()
        onLoading(false)
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: ExampleFragmentContract.View) {
        this.view = view
    }

}