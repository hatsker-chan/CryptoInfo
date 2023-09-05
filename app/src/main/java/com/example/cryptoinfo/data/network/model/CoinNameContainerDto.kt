package com.example.cryptoinfo.data.network.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class CoinNameContainerDto (
    @SerializedName("CoinInfo")
    @Expose
    var coinName: CoinNameDto? = null
)