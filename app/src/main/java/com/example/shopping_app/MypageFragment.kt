package com.example.shopping_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.databinding.FragmentMypageBinding

class MypageFragment : Fragment() {
    private lateinit var binding: FragmentMypageBinding // 바인딩클래스
    private lateinit var mypageAdapter: MypageAdapter
    private lateinit var data2: Data2

    // 프래그먼트 + 레이아웃 연결 ==> 뷰 생성
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageBinding.inflate(inflater, container, false)
        // 프래그먼트와 뷰모델 연계하고 라이브데이터 관찰 등록
        val viewModel = ViewModelProvider(this).get(MypageViewModel::class.java)
        val textView: TextView = binding.textMypage
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it  // 뷰모델의 text 변수를 관찰하다가 변경되면 이 구문 처리
        }
        //data
        data2 = Data2(
            mutableListOf("독립성", "친화력", "활동성", "건강", "훈련습득력"),
            mutableListOf(10, 40, 30, 20, 40),
            mutableListOf("혼자 있는 것을 싫어해요. 노즈워크로 독립성을 길러주세요", "누구에게나 친근하게 다가가고 애교 만점이에요.", "활동량이 많은 친구에요. 산책을 자주 시켜주세요.", "건강을 위해 영양제를 챙겨주세요.", "똑똑하고 사람을 잘 따르는 아이에요.")
        )

        val recyclerView: RecyclerView = binding.mypageItem

        mypageAdapter = MypageAdapter(data2)
        binding.mypageItem.layoutManager = LinearLayoutManager(requireContext())
        binding.mypageItem.adapter = mypageAdapter


        mypageAdapter.notifyDataSetChanged()

        return binding.root
    }
}