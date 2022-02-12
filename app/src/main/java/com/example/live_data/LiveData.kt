package com.example.live_data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

open class LiveData : ViewModel() {
    val data: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val number: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    private val arrayName: MutableLiveData<Array<String>> by lazy {
        MutableLiveData<Array<String>>()
    }

    fun onClickButtonMale() {
        arrayName.value = Name().male
    }

    fun onClickButtonFemale() {
        arrayName.value = Name().female
    }

    fun check(num: Int) : String {
        return if ( num in 1..20 ){
            arrayName.value!![num - 1]
        }
        else "Please choose Gender or check the number"
    }
}
