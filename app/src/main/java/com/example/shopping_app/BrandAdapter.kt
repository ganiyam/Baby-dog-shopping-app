package com.example.shopping_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.databinding.BrandItemBinding

//class Data (val brandList: MutableList<String>, val brandImg1: MutableList<Int>, val brandImg2: MutableList<Int>, val brandImg3: MutableList<Int>)
class Data(
    val brandNumber: MutableList<String>,
    val brandList: MutableList<String>,
    val brandImg: MutableList<Int>,
    val brandImg2: MutableList<Int>,
    val brandImg3: MutableList<Int>,
)

class BrandAdapter(val data:Data) : RecyclerView.Adapter<BrandAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandAdapter.MyViewHolder {
        val binding = BrandItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (position < data.brandNumber.size && position < data.brandList.size && position < data.brandImg.size && position < data.brandImg2.size && position < data.brandImg3.size) {
            holder.bind(
                data.brandNumber[position],
                data.brandList[position],
                data.brandImg[position],
                data.brandImg2[position],
                data.brandImg3[position]
            )
        }
    }

    override fun getItemCount(): Int {
//        return data.brandList.size
        // 모든 리스트의 크기가 동일한지 확인하여 반환
        return minOf(
            data.brandNumber.size,
            data.brandList.size,
            data.brandImg.size,
            data.brandImg2.size,
            data.brandImg3.size
        )
    }

    class MyViewHolder(val binding: BrandItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(brandNum: String, brandName: String, brandImg: Int, brandImg2: Int, brandImg3: Int){
            binding.brandNum.text = brandNum
            binding.brandName.text = brandName
            binding.brandImg1.setImageResource(brandImg)
            binding.brandImg2.setImageResource(brandImg2)
            binding.brandImg3.setImageResource(brandImg3)
        }

    }



}