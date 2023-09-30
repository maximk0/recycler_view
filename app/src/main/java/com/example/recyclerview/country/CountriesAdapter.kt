package com.example.recyclerview.country

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ItemCountryBinding

class CountriesAdapter : RecyclerView.Adapter<CountryViewHolder>() {

    private var countries = emptyList<Country>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]

        with(holder.binding) {
            id.text =  holder.itemView.context.getString(R.string.id, country.id)
            flag.setImageResource(country.flag)
            nameCountry.text = country.name
        }
    }

    override fun getItemCount(): Int = countries.size

    fun setData(countryList: List<Country>) {
        countries = countryList
        notifyDataSetChanged()
    }
}

class CountryViewHolder(
    val binding: ItemCountryBinding
) : RecyclerView.ViewHolder(binding.root)
