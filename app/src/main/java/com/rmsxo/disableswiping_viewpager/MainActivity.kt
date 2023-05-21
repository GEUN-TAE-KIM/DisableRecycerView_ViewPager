package com.rmsxo.disableswiping_viewpager

import android.annotation.SuppressLint
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.rmsxo.disableswiping_viewpager.adapter.ViewPagerAdapter
import com.rmsxo.disableswiping_viewpager.databinding.ActivityMainBinding
import com.rmsxo.disableswiping_viewpager.fragment.ViewPagerFragment
import com.rmsxo.disableswiping_viewpager.util.CustomViewPager
import com.rmsxo.disableswiping_viewpager.util.OnRecyclerViewScrollListener
import com.rmsxo.disableswiping_viewpager.util.RecyclerViewDisabler

class MainActivity : AppCompatActivity(), OnRecyclerViewScrollListener {

    private lateinit var binding: ActivityMainBinding
    private var viewPagerFragment: ViewPagerFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)

        // 탭 레이아웃을 뷰페이저에 동기화
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        // 탭 이름 설정
        binding.tabLayout.getTabAt(0)?.text = "뷰페이저"
        binding.tabLayout.getTabAt(1)?.text = "프래그먼트"

       // setupTouchHandler()
    }

    // 뷰페이저 안에 리사이클러뷰의 터치 이벤트로 뷰페이저 스와이프 기능 정지
    /*private fun setupTouchHandler() {

        val topRecyclerView = viewPagerFragment?.getTopRecyclerView()

        binding.viewPager.setOnTouchListener { _, event ->
            val x = event.rawX.toInt()
            val y = event.rawY.toInt()

            val recyclerViewLocation = intArrayOf(0, 0)
            topRecyclerView?.getLocationOnScreen(recyclerViewLocation)

            val recyclerViewRect = Rect(
                recyclerViewLocation[0],
                recyclerViewLocation[1],
                recyclerViewLocation[0] + (topRecyclerView?.width ?: 0),
                recyclerViewLocation[1] + (topRecyclerView?.height ?: 0)
            )

            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.viewPager.isSwipeEnabled = !recyclerViewRect.contains(x, y)
                }

                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    binding.viewPager.isSwipeEnabled = true
                }
            }

            val recyclerViewDisabler = RecyclerViewDisabler (binding.viewPager)
            topRecyclerView?.addOnItemTouchListener(recyclerViewDisabler)

            false
        }
    }*/

    override fun onScroll(isScrolling: Boolean) {
        binding.viewPager.isSwipeEnabled = !isScrolling
    }

    fun disableSwipe() {
        binding.viewPager.isSwipeEnabled = false
    }

    fun enableSwipe() {
        binding.viewPager.isSwipeEnabled = true
    }


}