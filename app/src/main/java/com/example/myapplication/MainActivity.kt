package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonEquals.setOnClickListener(this)
        buttonDecimal.setOnClickListener(this)
        buttonDelete.setOnClickListener(this)
        buttonDivide.setOnClickListener(this)
        buttonMultiply.setOnClickListener(this)
        buttonSubtract.setOnClickListener(this)
        buttonAdd.setOnClickListener(this)
    }


    override fun onClick(view: View) {

        when (view.id) {
            R.id.button1 -> calculatorView("1")
            R.id.button2 -> calculatorView("2")
            R.id.button3 -> calculatorView("3")
            R.id.button4 -> calculatorView("4")
            R.id.button5 -> calculatorView("5")
            R.id.button6 -> calculatorView("6")
            R.id.button7 -> calculatorView("7")
            R.id.button8 -> calculatorView("8")
            R.id.button9 -> calculatorView("9")
            R.id.button0 -> calculatorView("0")
            R.id.buttonDecimal -> calculatorView(".")
            R.id.buttonMultiply -> calculatorView("*")
            R.id.buttonDivide -> calculatorView("/")
            R.id.buttonSubtract -> calculatorView("-")
            R.id.buttonAdd -> calculatorView("+")
            R.id.buttonEquals -> equation()
            R.id.buttonDelete -> calculator.setText("")
        }
    }

        // CHANGE VIEW IN CALCULATOR
    private fun calculatorView(str: String){
        var current = calculator.text.toString()
        calculator.setText(current + str)
    }

        // PERFORM OPERATIONS
    private fun equation(){
        var method: Char = 'a'
        var place: Int = 0

            // TAKE FINAL STRING AND FIND LOCATION OF OPERATOR
            // SPLIT STRING INTO num1, method (operator), num2
        val str = calculator.text.toString()
        for(i in 0..str.length-1){
            if(str[i] == '-' || str[i] == '+' || str[i] == '/' || str[i] == '*' ){
                method = str[i]
                place = i
            }
        }

        val num1 = str.subSequence(0, place)
        val num2 = str.subSequence(place+1, str.length)
        var result: Int = 0
        val fraction: Double

            // PERFORM EQUATION
        when(method){
            '+' -> result = num1.toString().toInt() + num2.toString().toInt()
            '-' -> result = num1.toString().toInt() - num2.toString().toInt()
            '*' -> result = num1.toString().toInt() * num2.toString().toInt()
        }

            // PRINT RESULT (IF DIVISION RESULT IS FRACTION -> CHANGE TO DOUBLE)
        if(method == '/'){
            fraction = num1.toString().toDouble() / num2.toString().toDouble()
            if(fraction % 1.0 == 0.0)
                calculator.setText(fraction.toInt().toString())
            else
                calculator.setText(fraction.toString())
        }
        else
            calculator.setText(result.toString())


    }
}