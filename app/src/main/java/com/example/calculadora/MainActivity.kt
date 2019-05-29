package com.example.calculadora

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private var lastDigitWasNumeric: Boolean = false
    private var isInvalideOperation: Boolean = false
    private var lastDigitWasDecimalPoint: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(v: View) {
        if (this.isInvalideOperation) {
            textView_entrada_usuario.text = (v as Button).text
            this.isInvalideOperation = false
        } else {
            textView_entrada_usuario.append((v as Button).text)
        }
        this.lastDigitWasNumeric = true
    }

    fun onOperator(v: View) {
        if (this.lastDigitWasNumeric && !this.isInvalideOperation) {
            textView_entrada_usuario.append((v as Button).text)
            this.lastDigitWasNumeric = false
            this.lastDigitWasDecimalPoint = false
        } else {
            dialog()
        }
    }

    fun onDecimalPoint(v: View) {
        if (this.lastDigitWasNumeric && !this.isInvalideOperation && !this.lastDigitWasDecimalPoint) {
            textView_entrada_usuario.append((v as Button).text)
            this.lastDigitWasNumeric = false
            this.lastDigitWasDecimalPoint = false
        }
    }

    fun onEqual(v: View) {
        if (this.lastDigitWasNumeric && !isInvalideOperation) {
            try {
                val resultado = ExpressionBuilder(textView_entrada_usuario.text.toString()).build().evaluate()
                textView_entrada_usuario.text = resultado.toString()
                lastDigitWasDecimalPoint = true
            }catch (e: ArithmeticException){
                this.isInvalideOperation = true
                this.lastDigitWasNumeric = false
            }
        } else {
            dialog()
        }
    }

    fun onClear(v: View) {
        textView_entrada_usuario.text = ""
        this.lastDigitWasNumeric = false
        this.isInvalideOperation = false
        this.lastDigitWasDecimalPoint = false
    }

    private fun dialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.operacao_invalida))
            .setMessage(getString(R.string.digite_operacao_valida))
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }

}
