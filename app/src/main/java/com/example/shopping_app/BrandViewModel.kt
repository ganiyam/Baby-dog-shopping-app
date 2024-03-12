package com.example.shopping_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BrandViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "브랜드"
    }
    val text: LiveData<String> = _text
}