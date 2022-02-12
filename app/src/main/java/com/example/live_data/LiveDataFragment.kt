package com.example.live_data

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.fragment.app.activityViewModels
import com.example.live_data.databinding.FragmentLiveDataBinding


class LiveDataFragment : Fragment() {
    private lateinit var binding: FragmentLiveDataBinding
    private lateinit var changeObserver : Observer<String>
    private val model: LiveData by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_live_data, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        changeObserver = Observer<String> { value ->
            binding.liveDataReceive.text  = value
        }
        model.data.observe(this,changeObserver)
    }


}