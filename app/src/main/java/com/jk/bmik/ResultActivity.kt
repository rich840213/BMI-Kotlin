package com.jk.bmik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import java.text.Format

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val bmi: Float = intent.getFloatExtra("BMI", 0f)

        // 第一種方式
        // result.text = "Your BMI is $bmi"

        // 第二種方式
        result.text = bmi.toString().printBMI()
    }

    fun String.printBMI(): String {
        return "Your BMI is " + this
    }
}
