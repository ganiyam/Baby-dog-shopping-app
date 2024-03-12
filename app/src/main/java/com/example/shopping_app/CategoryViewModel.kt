package com.example.shopping_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoryViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "카테고리"
    }
    val text: LiveData<String> = _text
}