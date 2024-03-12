package com.example.shopping_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.databinding.MypageItemBinding

class Data2 (
    val pageList: MutableList<String>,
    val progress: MutableList<Int>,
    val pageText: MutableList<String>
)
class MypageAdapter(val data2:Data2) : RecyclerView.Adapter<MypageAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MypageAdapter.MyViewHolder {
        val binding = MypageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MypageAdapter.MyViewHolder, position: Int) {
        holder.bind(data2.pageList[position], data2.pageText[position])
        holder.updateProgressBar(data2.progress[position])
    }

    override fun getItemCount(): Int {
        return data2.pageList.size
    }

    // 아이템 뷰의 구성 요소를 담당하는 뷰홀더
    class MyViewHolder(val binding: MypageItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(mypageText: String, mypageText2: String){
            binding.mypageText.text = mypageText
            binding.mypageText2.text = mypageText2
        }

        fun updateProgressBar(progressValue: Int) {
            binding.pageProgressBar.progress = progressValue
        }

    }
}