package com.example.cryptoinfo.data.network.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class CoinNamesListDto (
    @SerializedName("Data")
    @Expose
    var names: List<CoinNameContainerDto>? = null
)