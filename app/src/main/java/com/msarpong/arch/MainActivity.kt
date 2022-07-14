package com.msarpong.arch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.msarpong.arch.databinding.ActivityMainBinding
import com.msarpong.arch.fragments.FirstFragment
import com.msarpong.arch.fragments.SecondFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstF = FirstFragment()
        val secondF = SecondFragment()

        binding.goToFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, firstF)
                commit()
            }
        }

        binding.goToFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, secondF)
                commit()
            }
        }


    }
}