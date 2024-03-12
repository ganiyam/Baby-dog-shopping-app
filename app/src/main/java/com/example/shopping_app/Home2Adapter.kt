package com.example.shopping_app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class Home2Adapter(adapter: FragmentActivity) : FragmentStateAdapter(adapter){
    private val images2 = listOf<Int>(R.drawable.cutie, R.drawable.rudolf, R.drawable.dress, R.drawable.fleece, R.drawable.dino, R.drawable.padded, R.drawable.hanbok)
    private val titles2 = listOf<String>("심플하지만 귀엽게, 꾸안꾸룩", "크리마스를 즐기자, 루돌프룩", "산책할땐 꾸미자, 원피스룩", "눈 오는 날엔, 후리스룩", "쎄지고 싶을땐, 공룡룩",
            "추운겨울교복, 패딩룩", "설날 추석엔, 한복룩")

    override fun getItemCount() = images2.size

    override fun createFragment(position: Int): Fragment {
        return when ( position) {
            0 -> Home3Fragment.newInstance(images2[0], titles2[0])
            1 -> Home3Fragment.newInstance(images2[1], titles2[1])
            2 -> Home3Fragment.newInstance(images2[2], titles2[2])
            3 -> Home3Fragment.newInstance(images2[3], titles2[3])
            4 -> Home3Fragment.newInstance(images2[4], titles2[4])
            5 -> Home3Fragment.newInstance(images2[5], titles2[5])
            6 -> Home3Fragment.newInstance(images2[6], titles2[6])
            7 -> Home3Fragment.newInstance(images2[7], titles2[7])
            else -> Home3Fragment.newInstance(images2[0], titles2[0])
        }
    }

}