package com.example.shopping_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.shopping_app.databinding.CategoryWidthrecBinding
import com.example.shopping_app.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding // 바인딩클래스
    // main viewpager2
    private lateinit var pager: ViewPager2
    //그리드뷰
    private lateinit var recyclerView: RecyclerView
    private var adapter: CategoryGridAdapter?=null
    private var cateList: MutableList<Category> = mutableListOf()

    //리싸이클러뷰 브랜드
    private lateinit var category2adapter: CategoryBranAdapter
    private lateinit var data: CateData

    //recyclerview christmas
    private lateinit var categorychrisadapter: CategoryChrisAdapter
    private lateinit var chrisdata: CateChrisData


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        val textView: TextView = binding.textCategory
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        //첫번째 viewpager2
        pager = binding.mainviewpager2
        pager.adapter = CategoryMainAdapter(requireActivity())

        //그리드뷰 만들기(4열)
        recyclerView = binding.cateRe
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)

        adapter = CategoryGridAdapter(requireContext(), cateList)
        recyclerView.adapter = adapter

        //recyclerview categorybrand! 옆으로(좌우로) 스와이프 되게 만듬
        data = CateData(
            mutableListOf(R.drawable.cate_brand_crdy,R.drawable.cate_brand_fa,R.drawable.cate_brand_eyou,
                R.drawable.cate_brand_tori,R.drawable.cate_brand_dang,R.drawable.cate_brand_woo),
            mutableListOf("코지로지데이","패션퍼피","이유","토리블리","댕구르르","우다다다")
        )
        category2adapter = CategoryBranAdapter(data)
        //가로로 이동하게 해주는 설정을 여기서 해준다.
        binding.cateBrandRe.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.cateBrandRe.adapter = category2adapter

        //recyclerbiew category christmas
        chrisdata = CateChrisData(
            mutableListOf(R.drawable.cate_chris1, R.drawable.cate_chris2, R.drawable.cate_chris3,
                R.drawable.cate_chris4, R.drawable.cate_chris5, R.drawable.cate_chris6),
            mutableListOf("이야","담무네 수제간식", "펫다이닝맘마", "찹앤찹", "이야","코카"),
            mutableListOf("강아지 크리스마스 간식세트","강아지케이크(크리스마스)","강아지 크리스마스 마카롱",
                "산타의 선물보따리","강아지 크리스마스 선물","강아지 크리스마스 케이크"),
            mutableListOf("9,900원","10,000원","17,500원","18,800원","22,000원","33,000원")

        )
        categorychrisadapter = CategoryChrisAdapter(chrisdata)
        binding.cateChrisRe.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.cateChrisRe.adapter = categorychrisadapter

        //gird
        categrid()

        return binding.root
    }

    //gridview data 넣기
    private fun categrid(){
        val images = intArrayOf(
            R.drawable.cate_modu,
            R.drawable.cate_fashion,
            R.drawable.cate_walk,
            R.drawable.cate_play,
            R.drawable.cate_living,
            R.drawable.cate_christ,
            R.drawable.cate_winter,
            R.drawable.cate_yam
        )
        var img = Category(images[0], "전체보기")
        cateList.add(img)
        img = Category(images[1], "패션/악세사리")
        cateList.add(img)
        img = Category(images[2], "하네스/줄")
        cateList.add(img)
        img = Category(images[3], "장난감/훈련")
        cateList.add(img)
        img = Category(images[4], "리빙용품")
        cateList.add(img)
        img = Category(images[5], "홈파티")
        cateList.add(img)
        img = Category(images[6], "겨울감성룩")
        cateList.add(img)
        img = Category(images[7], "홈파티간식")
        cateList.add(img)

        adapter?.notifyDataSetChanged()
    }
}