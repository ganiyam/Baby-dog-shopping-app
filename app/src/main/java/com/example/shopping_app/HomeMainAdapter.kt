package com.example.shopping_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class HomeMainAdapter(val context: Context, val homeList: MutableList<Home>) : RecyclerView.Adapter<HomeMainAdapter.MyViewHolder>(){

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img: ImageView = itemView.findViewById(R.id.re_img)
    }

    //아이템뷰 객체 생성
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeMainAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_recyclerview, parent, false)
        return MyViewHolder(itemView)
    }

    //아이템뷰 데이터 결합
    override fun onBindViewHolder(holder: HomeMainAdapter.MyViewHolder, position: Int) {
        val home = homeList.get(position)
        holder.img.setImageResource(home.img)
    }

    override fun getItemCount() = homeList.size
}