package com.example.cryptoinfo.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoinfo.databinding.ActivityCoinDetailBinding
import com.squareup.picasso.Picasso


class CoinDetailActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityCoinDetailBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[CoinViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
            finish()
            return
        }
        val fromSymbol =
            intent.getStringExtra(EXTRA_FROM_SYMBOL) ?: throw RuntimeException("fromSymbol is null")

        viewModel.getDetailInfo(fromSymbol).observe(this) {
            with(binding) {
                Picasso.get().load(it.imageUrl).into(ivCoinLogo)
                tvPrice.text = it.price.toString()
                tvPriceMin.text = it.lowDay.toString()
                tvPriceMax.text = it.highDay.toString()
                tvLastMarket.text = it.lastMarket
                tvLastUpdate.text = it.lastUpdate
                tvFromSymbol.text = it.fromSymbol
                tvToSymbol.text = it.toSymbol
            }
        }
    }

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"
        fun newIntent(context: Context, fSym: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fSym)
            return intent
        }
    }
}