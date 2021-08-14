package com.badmitry.mkb.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.badmitry.domain.entities.ResponseData
import com.badmitry.mkb.R
import com.badmitry.mkb.app.MKBApplication
import com.badmitry.mkb.databinding.MainLayoutBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainLayoutBinding
    private lateinit var adapter: MainRVAdapter

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_layout)
        initRV()
        val responseData = ResponseData(
            0,
            getString(R.string.download_data),
            getString(R.string.download_data),
            getString(R.string.download_data),
            getString(R.string.download_data),
            mutableListOf(),
            0,
            getString(R.string.download_data)
        )
        binding.responseData = responseData
        MKBApplication.component.inject(this)
        initComponents()
    }

    override fun onResume() {
        super.onResume()
        initViewModule()
    }

    private fun initViewModule() {
        viewModel.getAnswerLiveData().observe(this, { value ->
            binding.responseData = value
            adapter.setData(value.rates)
        })
        downloadExchangeRates()
    }

    private fun initComponents() {
        binding.btnUpdate.setOnClickListener {
            downloadExchangeRates()
        }
    }

    private fun downloadExchangeRates() {
        viewModel.downloadExchangeRates(
            getString(R.string.request_uid),
            getString(R.string.request_type),
            getString(R.string.request_rid)
        )
    }

    private fun initRV() {
        adapter = MainRVAdapter(this)
        binding.rvRates.layoutManager =
            LinearLayoutManager(this)
        binding.rvRates.adapter = adapter
    }

    override fun onPause() {
        super.onPause()
        viewModel.onCleared()
    }
}