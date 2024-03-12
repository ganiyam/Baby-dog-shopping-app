package com.example.shopping_app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CategoryMainAdapter(adapter: FragmentActivity) : FragmentStateAdapter(adapter) {
    private val image = listOf<Int>(R.drawable.catemain1, R.drawable.catemain2, R.drawable.catemain3)
    private val text = listOf<String>("1/3","2/3","3/3")
    override fun getItemCount() = image.size

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> CategoryMainFragment.newInstance(image[0], text[0])
            1 -> CategoryMainFragment.newInstance(image[1], text[1])
            2 -> CategoryMainFragment.newInstance(image[2], text[2])
            else ->CategoryMainFragment.newInstance(image[0], text[0])
        }
    }

}