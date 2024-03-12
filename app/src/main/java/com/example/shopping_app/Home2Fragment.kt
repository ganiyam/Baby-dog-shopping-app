package com.example.shopping_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.shopping_app.databinding.HomeinnerfragmentBinding

class Home2Fragment : Fragment() {

    private lateinit var binding: HomeinnerfragmentBinding

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.homeinnerfragment, container, false)

        viewPager = view.findViewById(R.id.homeimageview)

        // 이미지를 변경하기 위한 이미지 리스트
        val images = listOf(R.drawable.meon_main, R.drawable.ddo_main, R.drawable.ddo_main2, R.drawable.ble_main)
        val names = listOf("먼지", "뚜까", "뚜까", "블리")
        val minis = listOf(R.drawable.meon_mini, R.drawable.ddo_mini, R.drawable.ddo_mini, R.drawable.ble_mini)
        val contents = listOf("안녕 나는 먼지 산책해서 너무 신났찌😝", "잠이나 자자", "자기야. 왜 또 칭얼거려.", "블리와 크리스마스🎄🦌")


        adapter = HomeAdapter(requireActivity(), images, names, minis, contents)
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 3

        // 페이지 간 간격 설정 다음과 전 이미지가 미리 뜰 수 있게 설정
        val offsetBetweenPages = resources.getDimensionPixelOffset(R.dimen.offsetBetweenPages).toFloat()
        viewPager.setPageTransformer { page, position ->
            val myOffset = position * -(2 * offsetBetweenPages)
            if (position < -1) {
                page.translationX = -myOffset
            } else if (position <= 1) {
                val scaleFactor = 0.8f.coerceAtLeast(1 - kotlin.math.abs(position))
                page.translationX = myOffset
                page.scaleY = scaleFactor
                page.alpha = scaleFactor
            } else {
                page.alpha = 0f
                page.translationX = myOffset
            }
        }

        return view
    }

}


