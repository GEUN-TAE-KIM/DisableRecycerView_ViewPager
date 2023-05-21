package com.rmsxo.disableswiping_viewpager.util

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    var isSwipeEnabled = true

    override fun onInterceptTouchEvent(event: MotionEvent?): Boolean {
        return isSwipeEnabled && super.onInterceptTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return isSwipeEnabled && super.onTouchEvent(event)
    }


}
