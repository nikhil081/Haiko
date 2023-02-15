package com.example.haiko.activities

import android.app.Application
import com.example.haiko.api.CryptoService
import com.example.haiko.api.RetrofitHelper
import com.example.haiko.repositories.CryptoRepository


class CryptoApplication : Application() {

 lateinit var cryptoRepository: CryptoRepository

 override fun onCreate() {
  super.onCreate()
  initialize()
 }

 private fun initialize() {
  val quoteService = RetrofitHelper.getInstance().create(CryptoService::class.java)
  cryptoRepository = CryptoRepository(quoteService, applicationContext)
 }
}