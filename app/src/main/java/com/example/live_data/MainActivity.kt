package com.example.live_data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.live_data.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    private val liveData: LiveData by viewModels()
    private var check: Int = 0
    private var num: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        val fragment = findViewById<View>(R.id.something)
        val yes = this.resources.getColor(R.color.btn_after_clicking)
        val no = this.resources.getColor(R.color.purple_500)

            //Handle Button
        binding.btnRandomCheck.setOnClickListener {
            num = LiveDataModel().onClickButtonRandom()
            binding.tVRandomNumber.text = num.toString()
        }

        binding.btnCheck.setOnClickListener {
            num = binding.eTRandomText.text.toString().toIntOrNull()
            liveData.data.value = LiveDataModel().check(num, check)
        }

        binding.btnMale.setOnClickListener {
            check = 1
            binding.btnMale.setBackgroundColor(yes)
            binding.btnFemale.setBackgroundColor(no)
            Toast.makeText(this,"You choose Male", Toast.LENGTH_SHORT).show()
            liveData.data.value = LiveDataModel().onClickButtonMale(num)
        }

        binding.btnFemale.setOnClickListener {
            check = 2
            binding.btnFemale.setBackgroundColor(yes)
            binding.btnMale.setBackgroundColor(no)
            Toast.makeText(this,"You choose Female", Toast.LENGTH_SHORT).show()
            liveData.data.value = LiveDataModel().onClickButtonFemale(num)
        }


        binding.btnRandomCheck.setOnClickListener {
            num = LiveDataModel().onClickButtonRandom()
            binding.tVRandomNumber.text = num.toString()
            liveData.data.value = LiveDataModel().check(num, check)
        }

        binding.btnDeleteFragment.setOnClickListener {
            if (fragment.visibility == View.GONE){
                fragment.visibility = View.VISIBLE
            }
            else fragment.visibility = View.GONE
        }

    }
}