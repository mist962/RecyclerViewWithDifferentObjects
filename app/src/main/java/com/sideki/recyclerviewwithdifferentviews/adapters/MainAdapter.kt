package com.sideki.recyclerviewwithdifferentviews.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sideki.recyclerviewwithdifferentviews.R
import com.sideki.recyclerviewwithdifferentviews.models.data.ItemOne
import com.sideki.recyclerviewwithdifferentviews.models.data.ItemTwo
import kotlinx.android.synthetic.main.item_one.view.*
import kotlinx.android.synthetic.main.item_two.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var list = emptyList<Any>()

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainViewHolder(
        when (viewType) {
            1 -> LayoutInflater.from(parent.context).inflate(R.layout.item_one, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.item_two, parent, false)
        }
    )

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
        val curItem = list[position]

        when (holder.itemViewType) {
            1 -> {
                val itemOne = curItem as ItemOne
                holder.itemView.imageViewOne.setImageResource(itemOne.imageOne)
                holder.itemView.textViewOne.text = itemOne.textOne
            }
            else -> {
                val itemTwo = curItem as ItemTwo
                holder.itemView.imageViewTwo.setImageResource(itemTwo.imageTwo)
                holder.itemView.imageViewTwo.animate().rotation(720f).setStartDelay(2000).start()
                holder.itemView.textViewTwo.text = itemTwo.textTwo
            }
        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int {
        var a = 2
        if (!list.isEmpty()) {
            val item = list[position]
            if (item is ItemOne) {
                a = 1
            } else {
                a = 2
            }
        } else {
            Log.d("TAG", "List is EMPTY")
        }
        return a
    }

    fun setData(_list: List<Any>) {
        list = _list
        notifyDataSetChanged()
    }
}