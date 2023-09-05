package com.example.cryptoinfo.domain

data class CoinInfo(
    var fromSymbol: String,
    var toSymbol: String?,
    var price: Double?,
    var lastUpdate: String,
    var highDay: Double?,
    var lowDay: Double?,
    var lastMarket: String?,
    var imageUrl: String?
)