package com.example.donacin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.donacin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = 0x00000000

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.donacionRecycler.layoutManager = LinearLayoutManager(this)

        val viewModel: MainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val adapter = CardAdapter()
        binding.donacionRecycler.adapter = adapter

        viewModel.cardList.observe(this, Observer{
            cardList ->
            adapter.submitList(cardList)
            if (cardList.isEmpty()){
                binding.gone.visibility = View.VISIBLE
            }
        })
    }
}