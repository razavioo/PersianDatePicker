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
                updateDate(year, month, day)
            }

            override fun onMonthChanged(year: Int, month: Int, day: Int) {
                updateDate(year, month, day)
            }

            override fun onDayChanged(year: Int, month: Int, day: Int) {
                updateDate(year, month, day)
            }
        })
    }

    private fun updateDate(year: Int, month: Int, day: Int) {
        textDate.text = String.format(getString(R.string.date_format), year, month, day)
    }
}