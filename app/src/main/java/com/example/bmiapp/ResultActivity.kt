package com.example.bmiapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round

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
        // 소숫점 첫째자리까지만
        value = round(value*10)/10


        var resultText = ""     // 텍스트 바꾸는 변수
        var resImage = 0       // 이미지 바꾸는 변수
        var resColor = 0       // 텍스트 컬러 바꾸는 변수


        if (value < 18.5){
            resultText = "저체중"
            resImage = R.drawable.img_lv1
            resColor = Color.YELLOW
        }else if(value >= 18.5 && value < 23.0){
            resultText = "정상 체중"
            resImage = R.drawable.img_lv2
            resColor = Color.GREEN
        }else if(value >= 23.0 && value < 25.0) {
            resultText = "과체중"
            resImage = R.drawable.img_lv3
            resColor = Color.BLUE
        }else if(value >= 25.5 && value < 30.0) {
            resultText = "경도 비만"
            resImage = R.drawable.img_lv4
            resColor = Color.CYAN
        }else if(value >= 30.0 && value < 35.0) {
            resultText = "중정도 비만"
            resImage = R.drawable.img_lv5
            resColor = Color.MAGENTA
        }else{
            resultText = "고도 비만"
            resImage = R.drawable.img_lv6
            resColor = Color.RED
        }


        val tv_resValue = findViewById<TextView>(R.id.tv_resValue)
        val tv_resText = findViewById<TextView>(R.id.tv_resText)
        val tv_image = findViewById<ImageView>(R.id.iv_resImage)
        val btn = findViewById<Button>(R.id.btn_close)


        // tv_resValue에 value값 넣어주기
        tv_resValue.text = value.toString()
        tv_resText.text = resultText
        tv_image.setImageResource(resImage)
        tv_resText.setTextColor(resColor)


        btn.setOnClickListener {
            finish()
        }






    }
}