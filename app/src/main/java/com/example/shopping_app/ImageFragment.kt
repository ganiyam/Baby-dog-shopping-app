package com.example.shopping_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import de.hdodenhof.circleimageview.CircleImageView

class ImageFragment  : Fragment() {

    private var imageRes: Int = 0
    private var textRes: String = " "
    private var miniRes: Int = 0
    private var contentRes: String = " "


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_itemview, container, false)
        val imageView = view.findViewById<ImageView>(R.id.home_poster)
        val textView = view.findViewById<TextView>(R.id.home_names)
        val miniView = view.findViewById<CircleImageView>(R.id.home_mini)
        val contentView = view.findViewById<TextView>(R.id.home_contents)
        imageView.setImageResource(imageRes)
        textView.setText(textRes)
        miniView.setImageResource(miniRes)
        contentView.setText(contentRes)

        return view
    }

    companion object {
        fun newInstance(imageRes: Int, textRes: String, miniRes: Int, contentRes: String): ImageFragment {
            return ImageFragment().apply {
                this.imageRes = imageRes
                this.textRes = textRes
                this.miniRes = miniRes
                this.contentRes = contentRes
            }
        }
    }
}