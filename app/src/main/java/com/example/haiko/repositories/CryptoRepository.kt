package com.example.haiko.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.haiko.api.CryptoService
import com.example.haiko.model.Crypto


class CryptoRepository(
 private val cryptoService: CryptoService,
 private val applicationContext: Context
) {


  private val cryptoLiveData = MutableLiveData<List<Crypto>>()

    val cryptos: LiveData<List<Crypto>>
        get() = cryptoLiveData

 suspend fun getCrypto(vs_currency:String,order: String){
  val result = cryptoService.getCryptoList(vs_currency,order)
  if(result.body() !=null){
   cryptoLiveData.postValue(result.body())
  }
 }
}
