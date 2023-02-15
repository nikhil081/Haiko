package com.example.haiko.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.haiko.model.Crypto
import com.example.haiko.repositories.CryptoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Currency

class MainViewModel(private val repository: CryptoRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getCrypto("usd","market_cap_desc")
        }
    }



    val quotes : LiveData<List<Crypto>>
        get() = repository.cryptos
}