package com.example.bmiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)



        // MainActivity에서 보낸코드 받아주기
        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        // BMI 계산 (체중을 신장의 제곱으로 나눔)
        // height는 cm이니깐 100을 곱해서 m로 만든뒤, pow를 사용해서 제곱해주고, 이를 체중으로 나눠줌
        var value = weight / (height / 100.0).pow(2.0)


        var resultText = ""     // 텍스트 바꿈
        var resImage = ""       // 이미지 바꿈
        var resColor = ""       // 텍스트 컬러 바꿈



    }
}