package com.example.cryptoinfo.api

import com.example.cryptoinfo.pojo.CoinInfoListOfData
import com.example.cryptoinfo.pojo.CoinPriceInfo
import com.example.cryptoinfo.pojo.CoinPriceInfoRawData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "b55f2800d9d2c4eec9b9c661cfefd266ca4311b0f6a5974a83865764ebbca618"
        ): Single<CoinInfoListOfData>

    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms: String,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "b55f2800d9d2c4eec9b9c661cfefd266ca4311b0f6a5974a83865764ebbca618",
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String = CURRENCY

    ) : Single<CoinPriceInfoRawData>

    companion object{
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"

        private const val CURRENCY = "USD"
    }


}