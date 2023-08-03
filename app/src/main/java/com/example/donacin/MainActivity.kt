package com.example.donacin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.donacin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = 0x00000000

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.donacionRecycler.layoutManager = LinearLayoutManager(this)

        val cardList = mutableListOf<Card>()

        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))
        cardList.add(Card("El Cantaro", "19-21","Av. Paraguay c/ Mcal. López 343"))

        val adapter = CardAdapter()
        binding.donacionRecycler.adapter = adapter
        adapter.submitList(cardList)

        if (cardList.isEmpty()){
            binding.gone.visibility = View.VISIBLE
        }
    }
}