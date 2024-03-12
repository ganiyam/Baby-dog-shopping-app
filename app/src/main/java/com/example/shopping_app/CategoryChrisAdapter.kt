package com.example.shopping_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.databinding.CategoryChrisRecBinding

class CateChrisData(
    val chrisimg: MutableList<Int>,
    val chrisname: MutableList<String>,
    val chriscontent: MutableList<String>,
    val chrisprice: MutableList<String>
)
class CategoryChrisAdapter(val data:CateChrisData) : RecyclerView.Adapter<CategoryChrisAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryChrisAdapter.ViewHolder {
        val binding = CategoryChrisRecBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryChrisAdapter.ViewHolder, position: Int) {
        if(position < data.chrisimg.size && position < data.chrisname.size &&
            position < data.chriscontent.size && position < data.chrisprice.size){
            holder.bind(
                data.chrisimg[position],
                data.chrisname[position],
                data.chriscontent[position],
                data.chrisprice[position]
            )
        }
    }

    override fun getItemCount() = data.chrisimg.size

    class ViewHolder(val binding: CategoryChrisRecBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(chrisImg: Int, chrisName: String, chrisContent: String, chrisPrice: String){
            binding.cateChrisImg.setImageResource(chrisImg)
            binding.cateChrisBrandname.text = chrisName
            binding.cateChrisContent.text = chrisContent
            binding.cateChrisPrice.text = chrisPrice
        }
    }
}