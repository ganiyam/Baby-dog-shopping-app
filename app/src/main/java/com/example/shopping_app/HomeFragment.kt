package com.example.shopping_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.shopping_app.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding // 바인딩클래스
    private lateinit var recyclerView: RecyclerView
    private var adapter: HomeMainAdapter? = null
    private var homeList: MutableList<Home> = mutableListOf()
    //viewpager2 styleLookbook
    private lateinit var pager: ViewPager2

    private var home = 0
    // 프래그먼트 + 레이아웃 연결 ==> 뷰 생성
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // 프래그먼트와 뷰모델 연계하고 라이브데이터 관찰 등록
        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val textView: TextView = binding.textHome
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it  // 뷰모델의 text 변수를 관찰하다가 변경되면 이 구문 처리
        }

        //그리드뷰 만들기(2열)
        recyclerView = binding.homeRe
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        adapter = HomeMainAdapter(requireContext(), homeList)
        recyclerView.adapter = adapter


        //stylelookbook viewpager2
        pager = binding.viewPager2
        pager.adapter = Home2Adapter(requireActivity())


        //gridview
        prepareHome()

        pager.offscreenPageLimit = 3

        // 페이지 간 간격 설정 style Lookbook
        val offsetBetweenPages2 = resources.getDimensionPixelOffset(R.dimen.offsetBetweenPages2).toFloat()
        pager.setPageTransformer { page, position ->
            val myOffset = position * -(2 * offsetBetweenPages2)
            if (position < -1) {
                page.translationX = -myOffset
            } else if (position <= 1) {
                val scaleFactor = 0.8f.coerceAtLeast(1 - kotlin.math.abs(position))
                page.translationX = myOffset
                page.alpha = scaleFactor
            } else {
                page.alpha = 0f
                page.translationX = myOffset
            }
        }
        return binding.root

        // 중첩Fragment (Home2Fragment)를 생성하고 추가
        val nestedFragment = Home2Fragment()
        childFragmentManager.beginTransaction()
            .replace(R.id.inner_frag, nestedFragment)
            .commit()




    }

    //사진 그리드뷰에 넣기
    private fun prepareHome(){
        val covers = intArrayOf(
            R.drawable.home1,
            R.drawable.home2,
            R.drawable.home3,
            R.drawable.home4,
            R.drawable.home5,
            R.drawable.home6

        )
        homeList.clear() //기존데이터를 모두 제거, 사진이 늘어나는 문제를 해결
        for (cover in covers) {
            val a = Home(cover)
            homeList.add(a)
        }
    }
}