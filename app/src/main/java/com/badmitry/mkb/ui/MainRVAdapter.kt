package com.badmitry.mkb.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.badmitry.domain.entities.ExchangeRates
import com.badmitry.mkb.databinding.RatesListItemBinding

class MainRVAdapter(private val context: Context) :
    RecyclerView.Adapter<MainRVAdapter.ViewHolder>() {
    lateinit var adapterBinding: RatesListItemBinding

    private val data: MutableList<ExchangeRates> = mutableListOf()

    fun setData(data: List<ExchangeRates>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: RatesListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(rates: ExchangeRates) {
            binding.rates = rates
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        adapterBinding =
            RatesListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(adapterBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}