package com.example.haiko.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.haiko.R
import com.example.haiko.R.layout
import com.example.haiko.adapters.CryptoAdapter
import com.example.haiko.databinding.ActivityMainBinding
import com.example.haiko.model.User
import com.example.haiko.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
   private lateinit var mainViewModel: MainViewModel
   private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val userList = ArrayList<User>();
        userList.add(User("Nikhil"))
        userList.add(User("Akhil"))
        val recyclerViewAdapter = CryptoAdapter( userList )
        binding.rv.adapter = recyclerViewAdapter
        binding.rv.layoutManager = LinearLayoutManager(this, RecyclerView
            .VERTICAL, false)

    }


}