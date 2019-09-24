package com.example.weatherapp5.weatherdetail.forecast.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp5.R
import com.example.weatherapp5.weatherdetail.ICON_ENDPOINT
import com.example.weatherapp5.weatherdetail.ICON_FORMAT
import com.example.weatherapp5.weatherdetail.forecast.domain.entity.ForecastObject
import kotlinx.android.synthetic.main.forecast_item.view.*
import java.util.*

class ForecastAdapter(val context: Context) :
    RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var weatherEntities: List<ForecastObject> = Collections.emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.forecast_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return weatherEntities.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weatherEntity = weatherEntities[position]
        holder.bind(weatherEntity)
    }

    fun setWeatherEntities(weatherEntities: List<ForecastObject>) {
        this.weatherEntities = weatherEntities
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(forecastObject: ForecastObject) {
            val weather = forecastObject.weather?.get(0)

            if(weather != null) {
                itemView.tv_current_temperature.text = forecastObject.main?.temp.toString() + " F" ?: ""
                itemView.tv_forecast_description.text = weather.description
                itemView.tv_forecast_date.text = forecastObject.dtTxt?.split(" ")?.get(1) ?: ""

                Glide.with(itemView.context)
                    .load(ICON_ENDPOINT + weather.icon + ICON_FORMAT)
                    .into(itemView.iv_forecast_icon)
            }

        }

    }
}