package com.example.calculadora

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.example.calculadora.service.Calculadora
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var lastDigitWasNumeric: Boolean = false
    private var isInvalidOperation: Boolean = false
    private var lastDigitWasDecimalPoint: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Verifica se é um operador válido
     * Seta na tela o número digitado
     * Muda pra verdadeiro se foi pressionado um número
     */
    fun onDigit(v: View) {
        if (this.isInvalidOperation) {
            textView_user_input.text = (v as Button).text
            this.isInvalidOperation = false
        } else {
            textView_user_input.append((v as Button).text)
        }
        this.lastDigitWasNumeric = true
    }

    /**
     * Verifica se o último valor colocado na tela foi um número e se não é uma operação inválida
     * Seta na tela o operador digitado
     * Muda pra falso se o que foi digitado não era um número nem um ponto decimal
     * Caso tente colocar dois operadores em sequencia, é inflado o alert dialog
     */
    fun onOperator(v: View) {
        if (this.lastDigitWasNumeric && !this.isInvalidOperation) {
            textView_user_input.append((v as Button).text)
            this.lastDigitWasNumeric = false
            this.lastDigitWasDecimalPoint = false
        } else {
            dialog()
        }
    }

    /**
     * Verifica se o penúltimo dígito foi um número, se é uma operação válida e se não um ponto decimal
     * Caso verdadeiro seta o ponto decimal na tela
     * Caso tente colocar ponto decimal em sequência, infla o alert dialog
     */
    fun onDecimalPoint(v: View) {
        if (this.lastDigitWasNumeric && !this.isInvalidOperation && !this.lastDigitWasDecimalPoint) {
            textView_user_input.append((v as Button).text)
            this.lastDigitWasNumeric = false
            this.lastDigitWasDecimalPoint = false
        }else
            dialog()
    }

    /**
     * Verifica se o último valor colocado na tela foi um número e se não é uma operação inválida
     * Se for verdadeiro, envia a expressão como String para que seja feito o calculo e retorna o resultado em double
     * Caso tente calcular uma expressão inválida, o alert dialog é inflado
     */
    fun onEqual(v: View) {
        if (this.lastDigitWasNumeric && !isInvalidOperation) {
            try {
                val resultado = Calculadora.calcule(textView_user_input.text.toString())
                textView_output_result.text = resultado.toString()
                lastDigitWasDecimalPoint = true
            }catch (e: ArithmeticException){
                this.isInvalidOperation = true
                this.lastDigitWasNumeric = false
            }
        } else {
            dialog()
        }
    }

    /**
     * Seta todos os textView para vazio
     * Seta todos verificadores de entrada para falso
     */
    fun onClear(v: View) {
        textView_user_input.text = ""
        textView_output_result.text = ""
        this.lastDigitWasNumeric = false
        this.isInvalidOperation = false
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
