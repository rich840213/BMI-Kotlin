package com.jk.bmik

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        help.setOnClickListener {
            AlertDialog.Builder(this@MainActivity)
                .setMessage("Body mass index (BMI) is a value derived from the mass (weight) and height of a person.")
                .setPositiveButton("OK") { dialog: DialogInterface?, which: Int ->
                    Toast.makeText(this, "Testing", Toast.LENGTH_SHORT).show()
                }.show()
        }

        bmi.setOnClickListener {
            try {
                val w: Float = weight.text.toString().toFloat()
                val h: Float = height.text.toString().toFloat()
                val bmi: Float = w / (h * h)

                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                intent.putExtra("BMI", bmi)
                startActivity(intent)
            } catch (e: NumberFormatException) {
                e.printStackTrace()
                Toast.makeText(this, "Please input weight and height", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
