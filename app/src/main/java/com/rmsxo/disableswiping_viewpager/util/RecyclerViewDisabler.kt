package com.rmsxo.disableswiping_viewpager.util

import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewDisabler(val viewPager: CustomViewPager) : RecyclerView.OnItemTouchListener {

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        viewPager.isSwipeEnabled = e.action != MotionEvent.ACTION_MOVE
        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {

    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }

}