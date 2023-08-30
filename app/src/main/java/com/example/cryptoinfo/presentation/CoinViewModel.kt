package com.example.cryptoinfo.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.cryptoinfo.data.repository.CoinRepositoryImpl
import com.example.cryptoinfo.domain.CoinInfo
import com.example.cryptoinfo.domain.GetCoinInfoListUseCase
import com.example.cryptoinfo.domain.GetCoinInfoUseCase
import com.example.cryptoinfo.domain.LoadDataUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSyms: String): LiveData<CoinInfo> = getCoinInfoUseCase(fSyms)

    init {
        CoroutineScope(Dispatchers.IO).launch {
            loadDataUseCase()
        }
    }
}