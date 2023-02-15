package com.example.haiko.model

data class Crypto(
    val atl: Double,
    val atl_change_percentage: Double,
    val atl_date: String,
    val current_price: Double,
    val fully_diluted_valuation: Long,
    val high_24h: Double,
    val id: String,
    val image: String,
    val last_updated: String,
    val low_24h: Double,
    val market_cap: Long,
    val market_cap_change_percentage_24h: Double,
    val market_cap_rank: Int,
    val name: String,
    val price_change_24h: Double,
    val price_change_percentage_24h: Double,
    val roi: Any,
    val symbol: String,
)