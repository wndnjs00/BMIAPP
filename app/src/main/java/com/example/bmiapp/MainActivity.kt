package com.example.bmiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val heightEditText = findViewById<EditText>(R.id.et_height)
        val weightEditText = findViewById<EditText>(R.id.et_weight)
        val submitButton = findViewById<Button>(R.id.btn_submit)


        // submitButton 클릭 했을때
        submitButton.setOnClickListener {

            // 예외처리(아무것도 넣지 않았을떄 안넘어가도록)
            if(heightEditText.text.isEmpty()){
                Toast.makeText(this, "신장을 입력해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(weightEditText.text.isEmpty()){
                Toast.makeText(this, "체중을 입력해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            // 사용자가 입력한 신장,체중 텍스트 받아오기
            val height : Int = heightEditText.text.toString().toInt()
            val weight : Int = weightEditText.text.toString().toInt()

            // 받아온 값 넘겨주기
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height",height)
            intent.putExtra("weight",weight)
            startActivity(intent)


        }


    }
}