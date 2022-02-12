package com.example.live_data

import androidx.lifecycle.MutableLiveData
import java.util.*

class LiveDataModel {
    private var random: Random = Random()
    private var check: Boolean = false
    private lateinit var randomName : Array<String>

    fun onClickButtonMale(num: Int?): String {
        randomName = Name().male
        check = true
        return if (num != null && num >0 && num < 21){
            randomName[num - 1]
        } else "Error"
    }

    fun onClickButtonFemale(num: Int?): String {
        randomName = Name().female
        check = true
        return if (num != null && num >0 && num < 21){
            randomName[num - 1]
        } else "Error"
    }

    fun onClickButtonRandom(): Int {
        return random.nextInt(20 - 1) + 1
    }

    fun check(num: Int?, check: Int) : String {
        if (check != 0) {
            if (check == 1) {
            randomName = Name().male
            }
            if (check == 2) {
            randomName = Name().male
            }
            return if (num != null){
            randomName[num - 1]
            }
            else "Error"
        }
        else return "Error"
    }
}

