package com.example.haiko.api
import com.example.haiko.model.Crypto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoService {

 @GET("/api/v3/coins/markets")
 suspend fun getCryptoList(@Query("vs_currency") currency: String,
                           @Query("order") order: String,
                       ) : Response<List<Crypto>>
}