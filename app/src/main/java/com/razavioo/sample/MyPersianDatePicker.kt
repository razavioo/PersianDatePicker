package com.razavioo.sample

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import androidx.core.content.res.ResourcesCompat
import com.razavioo.persiandatepicker.PersianDatePicker

class MyPersianDatePicker @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : PersianDatePicker(context, attrs, defStyleAttr) {
    init {
        val typeface = ResourcesCompat.getFont(context, R.font.iran_sans)

        getYearNumberPicker().also { picker ->
            picker.wheelItemCount = 3
            picker.typeface = typeface
            picker.setSelectedTypeface(typeface)
            picker.selectedTextColor = Color.BLUE
            picker.setBackgroundResource(R.drawable.background_solid_white_round)
        }

        getMonthNumberPicker().also { picker ->
            picker.wheelItemCount = 3
            picker.typeface = typeface
            picker.setSelectedTypeface(typeface)
            picker.selectedTextColor = Color.BLUE
            picker.setBackgroundResource(R.drawable.background_solid_white_round)
        }

        getDayNumberPicker().also { picker ->
            picker.wheelItemCount = 6
            picker.typeface = typeface
            picker.setSelectedTypeface(typeface)
            picker.selectedTextColor = Color.BLUE
            picker.setBackgroundResource(R.drawable.background_solid_white_round)
        }

        getYearTitleTextView().setTextColor(Color.BLACK)
        getMonthTitleTextView().setTextColor(Color.BLACK)
        getDayTitleTextView().setTextColor(Color.BLACK)

        setMonthType(MonthType.STRING)
    }
}