package com.example.calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isNewOperator = true
    var edt1: TextView? = null
    var operator = "+"
    var initialNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if (isNewOperator) textView.setText("")
        isNewOperator = false
        var number: String = textView.text.toString()
        if (view.id == button1.id) {
            number += "1"
        } else if (view.id === button2.id) {
            number += "2"
        } else if (view.id === button3.id) {
            number += "3"
        } else if (view.id === button4.id) {
            number += "4"
        } else if (view.id === button5.id) {
            number += "5"
        }else if (view.id === button6.id) {
            number += "6"
        }else if (view.id === button7.id) {
            number += "7"
        }else if (view.id === button8.id) {
            number += "8"
        }else if (view.id === button9.id) {
            number += "9"
        }else if (view.id === button0.id) {
            number += "0"
        }else if (view.id === buttonPoint.id) {
            number += "."
        }
        textView.setText(number)
    }

    fun operatorEvent(view: View){
        isNewOperator = true
        initialNumber = textView.text.toString()
        if (view.id === buttonMultiplication.id) {
            operator = "*"
        } else if (view.getId() === buttonSoustraction.id){
            operator = "-"
        } else if (view.getId() === buttonDivision.id){
            operator = "/"
        } else if (view.getId() === buttonAddition.id){
            operator = "+"
        }
    }

    fun equalEvent(view: View?) {
        val newNumber: String = textView.text.toString()
        var output = 0.0
        if (operator === "+") output = initialNumber.toDouble() + newNumber.toDouble()
        if (operator === "/") output = initialNumber.toDouble() / newNumber.toDouble()
        if (operator === "*") output = initialNumber.toDouble() * newNumber.toDouble()
        if (operator === "-") output = initialNumber.toDouble() - newNumber.toDouble()
        textView.setText(output.toString() + "")
    }

    fun clearEvent(view: View?){
        textView.setText("0")
        isNewOperator = true
    }

    fun percentEvent(view: View?){
        val num: Double = textView.text.toString().toDouble() / 100
        textView.setText(num.toString() + "")
        isNewOperator = true
    }

}