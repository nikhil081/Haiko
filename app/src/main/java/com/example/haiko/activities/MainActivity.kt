package com.example.haiko.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.haiko.R
import com.example.haiko.R.layout
import com.example.haiko.adapters.CryptoAdapter
import com.example.haiko.databinding.ActivityMainBinding
import com.example.haiko.model.Crypto
import com.example.haiko.model.User
import com.example.haiko.viewmodel.MainViewModel
import com.example.haiko.viewmodel.MainViewModelFactory


class MainActivity : AppCompatActivity() {
   private lateinit var mainViewModel: MainViewModel
   private lateinit var binding: ActivityMainBinding

    private lateinit var cryptoList: List<Crypto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val cryptoAdapter  = CryptoAdapter(emptyList())
        binding.rv.adapter = cryptoAdapter
        binding.rv.layoutManager = LinearLayoutManager(this, RecyclerView
            .VERTICAL, false)
        val repository = (application as CryptoApplication).cryptoRepository

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)


        mainViewModel.quotes.observe(this, Observer {
            cryptoList = it
            cryptoAdapter.updateData(cryptoList)
            Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_SHORT).show()
        })

    }


}