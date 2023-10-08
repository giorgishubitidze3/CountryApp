package com.example.countryapp.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.countryapp.R


class CountryAdapter(private var countries: List<Country>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCountryName: TextView = itemView.findViewById(R.id.tvCountryName)
        val tvCountryCapital: TextView = itemView.findViewById(R.id.tvCountryCapital)
        val tvCountryArea: TextView = itemView.findViewById(R.id.tvCountryArea)
        val tvCountryCurrency: TextView = itemView.findViewById(R.id.tvCountryCurrency)
        val imgCountry: ImageView = itemView.findViewById(R.id.imgCountry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        holder.tvCountryName.text = country.name.common
        holder.tvCountryCapital.text = "Capital: ${country.capital.joinToString(", ")}"
        holder.tvCountryArea.text = "Area: ${country.area}"
        holder.tvCountryCurrency.text =
            "Currency: ${country.currencies?: "N/A"}"

        holder.imgCountry.load(country.flag) {
            crossfade(true)
        }


    }
    fun updateData(newCountries: List<Country>) {
        countries = newCountries
        notifyDataSetChanged()
    }
}