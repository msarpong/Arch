package com.msarpong.arch.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.msarpong.arch.R
import com.msarpong.arch.adapter.MainAdapter
import com.msarpong.arch.data.ListItem
import com.msarpong.arch.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var mainSmoothiesRV: RecyclerView

    private lateinit var adapter: MainAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.helloBtn.setOnClickListener {
            Toast.makeText(context, R.string.hello_world, Toast.LENGTH_LONG).show()
        }

        initRV()
        return binding.root
    }

    private fun initRV() {
        val l1 = ListItem(1, "K", "Kotlin")
        val l2 = ListItem(2, "H", "HTML")
        val l3 = ListItem(3, "J", "JavaScript")

        adapter = MainAdapter()
        adapter.submitList(listOf(l1, l2, l3))
        val recyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val Lc = ListItem(3, "J", "JavaScript")
            val Ld = ListItem(4, "W", "Website")
            val Le = ListItem(5, "R", "Ruby")
            val Lf = ListItem(6, "C", "C++")
            val Lg = ListItem(7, "S", "Swift")
            val Lh = ListItem(8, "F", "Flutter")
            adapter.submitList(listOf(Lc, Ld, Le, Lf, Lg, Lh))
        }, 3000)
    }

}