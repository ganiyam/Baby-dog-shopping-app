package com.example.shopping_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class CategoryMainFragment: Fragment(){
    private var image = 0
    private var text = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.category_main_fragment, container, false)

        val imageView = view.findViewById<ImageView>(R.id.cate_main_img)
        imageView.setImageResource(image)
        val textView = view.findViewById<TextView>(R.id.cate_main_text)
        textView.text = text


        return view
    }

    companion object {
        fun newInstance(image: Int, text: String) : CategoryMainFragment{
            return CategoryMainFragment().apply {
                this.image = image
                this.text = text
            }
        }
    }
}