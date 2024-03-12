package com.example.shopping_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.databinding.CategoryWidthrecBinding

class CateData(
    val cateimg: MutableList<Int>,
    val catetext: MutableList<String>
)

class CategoryBranAdapter(val data:CateData) : RecyclerView.Adapter<CategoryBranAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryBranAdapter.MyViewHolder {
        val binding = CategoryWidthrecBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if(position < data.cateimg.size && position < data.catetext.size){
            holder.bind(
                data.cateimg[position],
                data.catetext[position]
            )
        }
    }

    override fun getItemCount() = data.cateimg.size

    class MyViewHolder(val binding: CategoryWidthrecBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(cateImg: Int, catetext: String){
            binding.cateBestImg.setImageResource(cateImg)
            binding.cateBestText.text = catetext
        }
    }
}