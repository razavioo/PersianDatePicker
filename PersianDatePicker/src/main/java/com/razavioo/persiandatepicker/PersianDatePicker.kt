package com.razavioo.persiandatepicker

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.shawnlin.numberpicker.NumberPicker
import kotlinx.android.synthetic.main.persian_date_picker.view.*
import saman.zamani.persiandate.PersianDate

class PersianDatePicker @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var year: Int = 0
    private var month: Int = 0
    private var day: Int = 0

    private var listener: Listener? = null

    init {
        inflate(context, R.layout.persian_date_picker, this)

        yearNumberPicker.minValue = Integer.MIN_VALUE
        yearNumberPicker.maxValue = Integer.MAX_VALUE

        monthNumberPicker.minValue = 1
        monthNumberPicker.maxValue = 12

        initToday()

        yearNumberPicker.setOnValueChangedListener { _, _, newYear ->
            year = newYear
            listener?.onYearChanged(getPersianDate(), newYear)
            updateDayPicker()
        }

        monthNumberPicker.setOnValueChangedListener { _, _, newMonth ->
            month = newMonth
            listener?.onMonthChanged(getPersianDate(), newMonth)
            updateDayPicker()
        }

        dayNumberPicker.setOnValueChangedListener { _, _, newDay ->
            day = newDay
            listener?.onDayChanged(getPersianDate(), newDay)
        }
    }

    private fun initToday() {
        val persianDate = PersianDate()

        year = persianDate.shYear
        month = persianDate.shMonth
        day = persianDate.shDay

        yearNumberPicker.value = year
        monthNumberPicker.value = month
        dayNumberPicker.value = day
    }

    private fun getPersianDate(): PersianDate {
        return PersianDate().also {
            it.shYear = year
            it.shMonth = month
            it.shDay = day
        }
    }

    private fun updateDayPicker() {
        val monthDays = getPersianDate().getMonthDays(year, month)
        dayNumberPicker.minValue = 1
        dayNumberPicker.maxValue = monthDays

        if (day > monthDays) {
            day = monthDays
        }
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    fun getYearNumberPicker(): NumberPicker {
        return yearNumberPicker
    }

    fun getMonthNumberPicker(): NumberPicker {
        return monthNumberPicker
    }

    fun getDayNumberPicker(): NumberPicker {
        return dayNumberPicker
    }

    interface Listener {
        fun onYearChanged(persianDate: PersianDate, year: Int)
        fun onMonthChanged(persianDate: PersianDate, month: Int)
        fun onDayChanged(persianDate: PersianDate, day: Int)
    }
}