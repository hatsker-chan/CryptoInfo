package com.example.cryptoinfo.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class CoinInfoListOfData (
    @SerializedName("Data")
    @Expose
    var data: List<Datum>? = null
)