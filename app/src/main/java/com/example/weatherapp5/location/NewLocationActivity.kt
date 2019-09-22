package com.example.weatherapp5.location

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.weatherapp5.R
import kotlinx.android.synthetic.main.activity_new_location.*

class NewLocationActivity : AppCompatActivity() {

    companion object {
        val EXTRA_NEW_LOCATION_CITY = "new_location_city"
        val EXTRA_NEW_LOCATION_COUNTRY = "new_location_country"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_location)

        bt_add_location.setOnClickListener {
            val intent = Intent()
            val city = et_city.text.toString()
            val country = et_country.text.toString()
            if (TextUtils.isEmpty(city) || TextUtils.isEmpty(country)) {
                setResult(Activity.RESULT_CANCELED, intent)
            } else {
                intent.putExtra(EXTRA_NEW_LOCATION_CITY, city)
                intent.putExtra(EXTRA_NEW_LOCATION_COUNTRY, country)
                setResult(Activity.RESULT_OK, intent)
            }
            finish()
        }
    }
}
