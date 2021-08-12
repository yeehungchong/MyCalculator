package com.yeehungchong.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

var newExp : Boolean = true
var totalNum : String = ""
var action : String = ""
var isDotAvailable : Boolean = false

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEqual.setOnClickListener {
            val tempNum = tvScreen.text.toString()
            var result: Double? = null
            when (action) {
                "+" -> result = totalNum.toDouble() + tempNum.toDouble()
                "-" -> result = totalNum.toDouble() - tempNum.toDouble()
                "x" -> result = totalNum.toDouble() * tempNum.toDouble()
                "/" -> result = totalNum.toDouble() / tempNum.toDouble()
            }
            tvScreen.text = result.toString()
            newExp = true
        }

        btnClear.setOnClickListener {
            tvScreen.text = "0"
            newExp = true
            isDotAvailable = false
        }

    }

    fun btnOnClick(view: View) {
        if (newExp) {
            tvScreen.text = null
        }
        newExp = false
        val selectedBtn = view as Button
        var displayValue : String = tvScreen.text.toString()

        when (selectedBtn.id) {
            btnNum0.id -> displayValue += "0"
            btnNum1.id -> displayValue += "1"
            btnNum2.id -> displayValue += "2"
            btnNum3.id -> displayValue += "3"
            btnNum4.id -> displayValue += "4"
            btnNum5.id -> displayValue += "5"
            btnNum6.id -> displayValue += "6"
            btnNum7.id -> displayValue += "7"
            btnNum8.id -> displayValue += "8"
            btnNum9.id -> displayValue += "9"
            btnDot.id -> {
                if (!isDotAvailable) {
                    displayValue += "."
                    isDotAvailable = true
                }
            }
        }
        tvScreen.text = displayValue
    }

    fun btnOnClickAction(view: View) {
        val selectedBtn = view as Button
        when (selectedBtn.id) {
            btnPlus.id -> action = "+"
            btnMinus.id -> action = "-"
            btnMinus.id -> action = "x"
            btnDivide.id -> action = "/"
        }
        totalNum = tvScreen.text.toString()
        newExp = true
        isDotAvailable = false
    }

}