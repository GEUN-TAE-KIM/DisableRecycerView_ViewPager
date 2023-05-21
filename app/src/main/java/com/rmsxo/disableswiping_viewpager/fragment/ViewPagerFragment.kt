package com.rmsxo.disableswiping_viewpager.fragment

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rmsxo.disableswiping_viewpager.MainActivity
import com.rmsxo.disableswiping_viewpager.R
import com.rmsxo.disableswiping_viewpager.adapter.BottomAdapter
import com.rmsxo.disableswiping_viewpager.adapter.TopAdapter
import com.rmsxo.disableswiping_viewpager.databinding.FragmentViewpagerBinding
import com.rmsxo.disableswiping_viewpager.util.OnRecyclerViewScrollListener

class ViewPagerFragment : BaseFragment<FragmentViewpagerBinding>(R.layout.fragment_viewpager) {

    private var scrollListener: OnRecyclerViewScrollListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val top: Array<Int> = arrayOf(
            R.drawable.first,
            R.drawable.second,
            R.drawable.qwe
        )

        val bottom: Array<Int> = arrayOf(
            R.drawable.ujm,
            R.drawable.fifth,
            R.drawable.asd
        )

        // 상단
        val topAdapter = TopAdapter(top)
        binding.TopRecyclerViewId.adapter = topAdapter
        binding.TopRecyclerViewId.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // 하단
        val bottomAdapter = BottomAdapter(bottom)
        binding.BottomRecyclerViewId.adapter = bottomAdapter
        binding.BottomRecyclerViewId.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        binding.TopRecyclerViewId.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                // RecyclerView가 스크롤 중일 때 ViewPager의 스와이프를 비활성
                if (newState != RecyclerView.SCROLL_STATE_IDLE) {
                    (activity as? MainActivity)?.disableSwipe()
                } else {
                    // RecyclerView가 스크롤되지 않는 경우 ViewPager의 스와이프를 활성화
                    (activity as? MainActivity)?.enableSwipe()
                }
            }
        })

    }

    // 리사이클러뷰에 대한 getter를 제공
    fun getTopRecyclerView(): RecyclerView {
        return binding.TopRecyclerViewId
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnRecyclerViewScrollListener) {
            scrollListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        scrollListener = null
    }

}