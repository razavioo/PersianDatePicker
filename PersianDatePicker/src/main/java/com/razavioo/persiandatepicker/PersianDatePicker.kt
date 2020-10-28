package com.razavioo.persiandatepicker

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.shawnlin.numberpicker.NumberPicker
import kotlinx.android.synthetic.main.persian_date_picker.view.*
import saman.zamani.persiandate.PersianDate

open class PersianDatePicker @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    companion object {
        const val MINIMUM_DAY_VALUE = 1
        const val MINIMUM_MONTH_VALUE = 1
        const val MAXIMUM_MONTH_VALUE = 12
    }

    private var year: Int = 0
    private var month: Int = 0
    private var day: Int = 0

    private var listener: Listener? = null
    private var monthType: MonthType = MonthType.DIGIT

    init {
        inflate(context, R.layout.persian_date_picker, this)

        yearNumberPicker.minValue = Integer.MIN_VALUE
        yearNumberPicker.maxValue = Integer.MAX_VALUE

        monthNumberPicker.minValue = MINIMUM_MONTH_VALUE
        monthNumberPicker.maxValue = MAXIMUM_MONTH_VALUE

        initToday()

        yearNumberPicker.setOnValueChangedListener { _, _, newYear ->
            year = newYear
            listener?.onYearChanged(year, month, day)
            updateDayPicker()
        }

        monthNumberPicker.setOnValueChangedListener { _, _, newMonth ->
            month = newMonth
            listener?.onMonthChanged(year, month, day)
            updateDayPicker()
        }

        dayNumberPicker.setOnValueChangedListener { _, _, newDay ->
            day = newDay
            listener?.onDayChanged(year, month, day)
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
        dayNumberPicker.minValue = MINIMUM_DAY_VALUE
        dayNumberPicker.maxValue = monthDays

        if (day > monthDays) {
            day = monthDays
        }
    }

    private fun getStringMonthNames(): Array<String> {
        val persianDate = PersianDate()
        val monthNames = ArrayList<String>()
        for (month in MINIMUM_MONTH_VALUE..MAXIMUM_MONTH_VALUE) {
            monthNames.add(persianDate.monthName(month))
        }
        return monthNames.toTypedArray()
    }

    private fun getDigitMonthNames(): Array<String> {
        val monthNames = ArrayList<String>()
        for (month in MINIMUM_MONTH_VALUE..MAXIMUM_MONTH_VALUE) {
            monthNames.add(month.toString())
        }
        return monthNames.toTypedArray()
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

    fun getYearTitleTextView(): TextView {
        return textYearTitle
    }

    fun getMonthTitleTextView(): TextView {
        return textMonthTitle
    }

    fun getDayTitleTextView(): TextView {
        return textDayTitle
    }

    fun setMonthType(monthType: MonthType) {
        this.monthType = monthType

        monthNumberPicker.minValue = MINIMUM_MONTH_VALUE
        monthNumberPicker.maxValue = MAXIMUM_MONTH_VALUE
        if (monthType == MonthType.DIGIT) {
            monthNumberPicker.displayedValues = getDigitMonthNames()
        } else {
            monthNumberPicker.displayedValues = getStringMonthNames()
        }
        monthNumberPicker.value = month
    }

    enum class MonthType {
        DIGIT, STRING
    }

    interface Listener {
        fun onYearChanged(year: Int, month: Int, day: Int)
        fun onMonthChanged(year: Int, month: Int, day: Int)
        fun onDayChanged(year: Int, month: Int, day: Int)
    }
}