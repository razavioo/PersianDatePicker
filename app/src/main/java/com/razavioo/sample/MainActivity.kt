package com.razavioo.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.razavioo.persiandatepicker.PersianDatePicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        persianDatePicker.setListener(object : PersianDatePicker.Listener {
            override fun onYearChanged(year: Int, month: Int, day: Int) {
                textYear.text = "Year is $year"
            }

            override fun onMonthChanged(year: Int, month: Int, day: Int) {
                textMonth.text = "Month is $month"
            }

            override fun onDayChanged(year: Int, month: Int, day: Int) {
                textDay.text = "Day is $day"
            }
        })
    }
}