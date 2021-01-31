package jp.kaleidot725.navgraph.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jp.kaleidot725.navgraph.model.Counter

class CountViewModel(private val counter: Counter): ViewModel() {
    private val _countLiveData: MutableLiveData<Int> = MutableLiveData(counter.count)
    val countLiveData: LiveData<Int> = _countLiveData

    fun refresh() {
        _countLiveData.value = counter.count
    }

    fun increment() {
        counter.increment()
        refresh()
    }

    fun decrement() {
        counter.decrement()
        refresh()
    }
}