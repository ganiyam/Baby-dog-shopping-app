package com.example.shopping_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class Home3Fragment : Fragment() {
    private var img2 = 0
    private var title2 = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home2_fragment, container, false)

        val imageView = view.findViewById<ImageView>(R.id.fre2_image)
        imageView.setImageResource(img2)

        val titleView = view.findViewById<TextView>(R.id.fre2_text)
        titleView.text = title2



        return view
    }

    // java에서 static method 정의하는 것. 클래스명으로 실행하는 메소드
    companion object {
        fun newInstance(img2: Int, title2: String) : Home3Fragment{

            //apply 함수는 적용 대상에 구문들을 실행
            return Home3Fragment().apply {
                this.img2 = img2
                this.title2 = title2
            }
        }
    }

}