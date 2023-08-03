package com.example.donacin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CardAdapter: ListAdapter<Card, CardAdapter.CardViewHolder>(DiffCallBack) {

    companion object DiffCallBack: DiffUtil.ItemCallback<Card>(){
        override fun areItemsTheSame(olditem: Card, newItem: Card): Boolean{
            return olditem.title == newItem.title
        }

        override fun areContentsTheSame(olditem: Card, newItem: Card): Boolean{
            return olditem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapter.CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.donation_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardAdapter.CardViewHolder, position: Int) {
        val card = getItem(position)
        holder.title.text = card.title
        holder.hour.text = card.hour
        holder.direction.text = card.direction
    }

    inner class CardViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.title)
        val hour = view.findViewById<TextView>(R.id.hour)
        val direction = view.findViewById<TextView>(R.id.direction)
    }
}