package com.mvvm.app.base

import androidx.lifecycle.ViewModel


/**
 *
 *
 */

abstract class BaseViewModel : ViewModel()

/*open class BaseViewModel<T : IView> protected constructor() : ViewModel() {

    protected var compositeDisposable: CompositeDisposable
    protected var view: T? = null
    var isLoading = ObservableBoolean(true)

    init {
        compositeDisposable = CompositeDisposable()
    }

    fun attach(view: T) {
        this.view = view
    }

    fun detach() {
        view = null
    }

    fun clearSubscriptions() {
        compositeDisposable.clear()
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    fun onError(throwable: Throwable) {
        view!!.onError(throwable)
        setIsLoading(false)
    }
}*/
