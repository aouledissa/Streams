package io.aouledissa.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class StatefulViewModel<State> : ViewModel() {

    protected val disposables = CompositeDisposable()

    private var _state = MutableLiveData<State>()
    val viewState: LiveData<State> = _state

    fun switchState(state: State) {
        state?.let {
            _state.value = it
        }
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}