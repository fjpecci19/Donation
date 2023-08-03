package com.example.donacin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.donacin.databinding.DonationCardBinding

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
        val binding = DonationCardBinding.inflate(LayoutInflater.from(parent.context))
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardAdapter.CardViewHolder, position: Int) {
        val card = getItem(position)
        holder.bind(card)
    }

    inner class CardViewHolder(private val binding: DonationCardBinding): RecyclerView.ViewHolder(binding.root){
        fun bind (card: Card){
            binding.title.text = card.title
            binding.hour.text = card.hour
            binding.direction.text = card.direction

            binding.executePendingBindings()
        }
    }
}