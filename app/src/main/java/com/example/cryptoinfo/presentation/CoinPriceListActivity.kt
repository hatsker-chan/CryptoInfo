package com.example.cryptoinfo.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoinfo.databinding.ActivityCoinPriceListBinding
import com.example.cryptoinfo.domain.CoinInfo
import com.example.cryptoinfo.presentation.adapters.CoinInfoAdapter

class CoinPriceListActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCoinPriceListBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[CoinViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = CoinInfoAdapter(this)
        binding.recyclerViewCoinPriceList.adapter = adapter
        binding.recyclerViewCoinPriceList.itemAnimator = null
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coin: CoinInfo) {
                val intent = CoinDetailActivity.newIntent(
                    this@CoinPriceListActivity,
                    coin.fromSymbol
                )
                startActivity(intent)
            }
        }
        viewModel.coinInfoList.observe(this) {
            adapter.submitList(it)
        }
    }
}