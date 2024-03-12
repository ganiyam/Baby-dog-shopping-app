package com.example.shopping_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class CategoryGridAdapter(val context: Context, val cateList: MutableList<Category>) : RecyclerView.Adapter<CategoryGridAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.cate_img)
        val title: TextView = itemView.findViewById(R.id.cate_text)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryGridAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.category_rec, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryGridAdapter.MyViewHolder, position: Int) {
        val category = cateList.get(position)
        holder.image.setImageResource(category.image)
        holder.title.text = category.title
    }

    override fun getItemCount() = cateList.size
}