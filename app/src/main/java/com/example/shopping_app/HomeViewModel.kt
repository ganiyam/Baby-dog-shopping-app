package com.example.shopping_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    // 변경가능한 라이브데이터 객체 생성. 외부에서 접근 금지
    private val _text = MutableLiveData<String>().apply {
        value = "홈"
    }
    // 외부 접근용으로 변경불가능 라이브데이터 생성
    val text: LiveData<String> = _text  // 외부에서의 데이터 접근 오류를 방지하기 위한 방법
}