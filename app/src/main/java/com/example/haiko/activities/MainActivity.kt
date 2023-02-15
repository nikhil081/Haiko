package com.example.haiko.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.haiko.R
import com.example.haiko.R.layout
import com.example.haiko.viewmodel.MainViewModel
import com.example.haiko.viewmodel.MainViewModelFactory


class MainActivity : AppCompatActivity() {
   private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as CryptoApplication).cryptoRepository

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)


        mainViewModel.quotes.observe(this, Observer {
            Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_SHORT).show()
        })
    }
}