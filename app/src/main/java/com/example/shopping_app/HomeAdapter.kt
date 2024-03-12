package com.example.shopping_app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeAdapter(activity: FragmentActivity, private val images: List<Int>,
    private val names: List<String>,
    private val minis: List<Int>,
    private val contents: List<String>) : FragmentStateAdapter(activity) {

    override fun getItemCount() = images.size

    override fun createFragment(position: Int): Fragment {
        return ImageFragment.newInstance(images[position], names[position], minis[position], contents[position])
    }
}