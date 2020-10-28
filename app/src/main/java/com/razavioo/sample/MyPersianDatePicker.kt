package com.razavioo.sample

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import com.razavioo.persiandatepicker.PersianDatePicker

class MyPersianDatePicker @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : PersianDatePicker(context, attrs, defStyleAttr) {
    init {
        getYearNumberPicker().wheelItemCount = 3
        getMonthNumberPicker().wheelItemCount = 3
        getDayNumberPicker().wheelItemCount = 6
        getMonthNumberPicker().layoutDirection = View.LAYOUT_DIRECTION_RTL
        getYearTitleTextView().setTextColor(Color.RED)
        getMonthTitleTextView().setTextColor(Color.BLUE)
        getDayTitleTextView().setTextColor(Color.GREEN)
        setMonthType(MonthType.STRING)
    }
}