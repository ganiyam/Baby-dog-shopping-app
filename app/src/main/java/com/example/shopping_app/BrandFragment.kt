package com.example.shopping_app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.databinding.FragmentBrandBinding

class BrandFragment : Fragment(){
    private lateinit var binding: FragmentBrandBinding // 바인딩클래스

    private lateinit var brandAdapter: BrandAdapter
    private lateinit var data: Data

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBrandBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this).get(BrandViewModel::class.java)
        val textView: TextView = binding.textBrand
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }


        //데이터등록
        data = Data(
            mutableListOf("1", "2", "3", "4", "5", "6", "7"),
            mutableListOf("베니즈", "이츠독", "키니키니", "플로트", "루비디", "페스룸", "패리스독"),
            mutableListOf(R.drawable.be1, R.drawable.it1, R.drawable.kini1, R.drawable.pl1, R.drawable.lu1, R.drawable.peth1, R.drawable.paris1),
            mutableListOf(R.drawable.be2, R.drawable.it2, R.drawable.kini2, R.drawable.pl2, R.drawable.lu2, R.drawable.path2, R.drawable.paris2),
            mutableListOf(R.drawable.be3, R.drawable.it3, R.drawable.kini3, R.drawable.pl3, R.drawable.lu3, R.drawable.path3, R.drawable.paris3)
            )

        //리싸이클러뷰
        val recyclerView: RecyclerView = binding.brandItem

        brandAdapter = BrandAdapter(data)
        binding.brandItem.layoutManager = LinearLayoutManager(requireContext())
        binding.brandItem.adapter = brandAdapter

        return binding.root


    }
}