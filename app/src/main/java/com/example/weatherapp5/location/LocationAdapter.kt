package com.example.weatherapp4.home

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp4.database.LocationEntity
import com.example.weatherapp5.R
import com.example.weatherapp5.weatherdetail.currentWeather.WeatherDetailsActivity
import kotlinx.android.synthetic.main.location_item.view.*
import java.util.*

class LocationAdapter(private val context: Context) :
    RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var locations: List<LocationEntity> = Collections.emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.location_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return locations.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val location = locations.get(position)
        holder.bind(location)
        holder.itemView.setOnClickListener {
            Log.d("AQUI", location.city)
            val intent = Intent(context, WeatherDetailsActivity::class.java)
            intent.putExtra(EXTRA_CITY_DETAILS, location.city)
            intent.putExtra(EXTRA_COUNTRY_DETAILS, location.country)
            context.startActivity(intent)
        }
    }

    fun setLocations(locations: List<LocationEntity>) {
        this.locations = locations
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(location: LocationEntity) {
            itemView.tv_city.text = location.city
            itemView.tv_country.text = location.country
        }

    }

    companion object {
        val EXTRA_CITY_DETAILS = "city_details"
        val EXTRA_COUNTRY_DETAILS = "country_details"
    }
}