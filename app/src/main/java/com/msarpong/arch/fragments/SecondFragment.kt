package com.msarpong.arch.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.msarpong.arch.R
import com.msarpong.arch.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.helloBtn.setOnClickListener {
            Toast.makeText(context, R.string.hello_world,Toast.LENGTH_LONG).show()
        }

        return binding.root
    }

}