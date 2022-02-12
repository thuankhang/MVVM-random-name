package com.example.live_data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class LiveData : ViewModel() {
    val data: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}
