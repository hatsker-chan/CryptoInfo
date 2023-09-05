package com.example.cryptoinfo.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "full_price_list")
data class CoinInfoDbModel(

    @PrimaryKey
    var fromSymbol: String,

    var toSymbol: String? = null,

    var price: Double? = null,

    var lastUpdate: Long? = null,

    var highDay: Double? = null,

    var lowDay: Double? = null,

    var lastMarket: String? = null,

    var imageUrl: String? = null
)