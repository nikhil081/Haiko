package com.example.haiko.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.haiko.R
import com.example.haiko.model.Crypto
import com.example.haiko.model.User


class CryptoAdapter(var userList: List<Crypto>) : RecyclerView.Adapter<CryptoAdapter.MyViewHolder>() {

    class MyViewHolder( item: View) : RecyclerView.ViewHolder(item) {
        var llt: TextView = item.findViewById(R.id.text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.llt.text  = userList[position].name
    }


    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateData(cryptoList: List<Crypto>) {
        userList = cryptoList
        notifyDataSetChanged()
    }
}