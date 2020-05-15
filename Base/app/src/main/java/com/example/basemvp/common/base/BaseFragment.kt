package com.example.basemvp.common.base


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.basemvp.common.base.BaseActivity
import com.example.basemvp.common.base.BaseContract
import io.reactivex.disposables.CompositeDisposable


abstract class BaseFragment : Fragment(), BaseContract.View {

    //protected lateinit var fragmentComponent: FragmentComponent
    protected val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //injectDependency()
    }

    @Suppress("DEPRECATION")
//    private fun injectDependency() {
//        fragmentComponent = DaggerFragmentComponent.builder()
//            .fragmentModule(FragmentModule())
//            .build()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInit()
    }

    val baseActivity: BaseActivity
        get() = activity as BaseActivity

    override val rootView: View
        get() = baseActivity.rootView

    override fun onError(message: String) {
        baseActivity.onError(message)
    }

    override fun showWarningAlert(message: String) {
        baseActivity.showWarningAlert(message)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable.clear()
    }

    abstract fun onInit()
}