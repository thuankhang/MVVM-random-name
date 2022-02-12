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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        val fragment = findViewById<View>(R.id.something)
        val yes = this.resources.getColor(R.color.btn_after_clicking)
        val no = this.resources.getColor(R.color.purple_500)
        val random = Random()
        binding.btnRandomCheck.visibility = View.GONE
        binding.btnCheck.visibility = View.GONE

        binding.btnCheck.setOnClickListener {
            liveData.number.value = binding.eTRandomText.text.toString().toIntOrNull()
            if (liveData.number.value != null){
                liveData.data.value = liveData.check(liveData.number.value!!)
            }
        }

        binding.btnMale.setOnClickListener {
            binding.btnMale.setBackgroundColor(yes)
            binding.btnFemale.setBackgroundColor(no)
            binding.btnRandomCheck.visibility = View.VISIBLE
            binding.btnCheck.visibility = View.VISIBLE
            Toast.makeText(this,"You choose Male", Toast.LENGTH_SHORT).show()
            liveData.onClickButtonMale()
            if (liveData.number.value != null){
                liveData.data.value = liveData.check(liveData.number.value!!)
            }
        }

        binding.btnFemale.setOnClickListener {
            binding.btnFemale.setBackgroundColor(yes)
            binding.btnMale.setBackgroundColor(no)
            binding.btnRandomCheck.visibility = View.VISIBLE
            binding.btnCheck.visibility = View.VISIBLE
            Toast.makeText(this,"You choose Female", Toast.LENGTH_SHORT).show()
            liveData.onClickButtonFemale()
            if (liveData.number.value != null){
                liveData.data.value = liveData.check(liveData.number.value!!)
            }
        }


        binding.btnRandomCheck.setOnClickListener {
            liveData.number.value = random.nextInt(20 - 1) + 1
            binding.tVRandomNumber.text  = liveData.number.value.toString()
            liveData.data.value = liveData.check(liveData.number.value!!)
        }

        binding.btnDeleteFragment.setOnClickListener {
            if (fragment.visibility == View.GONE){
                fragment.visibility = View.VISIBLE
            }
            else fragment.visibility = View.GONE
        }

    }
}