package com.example.calculadora

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var primeiroValor: Float = 0F
    private var segundoValor: Float = 0F
    private lateinit var operador: String
    private lateinit var numeros: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numeros = ArrayList()
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v?.id) {
            cardView_um.id -> {
                numeros.add(textView_um.text.toString())
                textView_primeiro_valor.append(textView_um.text)
            }
            cardView_dois.id -> {
                numeros.add(textView_dois.text.toString())
                textView_primeiro_valor.append(textView_dois.text)
            }
            cardView_tres.id -> {
                numeros.add(textView_tres.text.toString())
                textView_primeiro_valor.append(textView_tres.text)
            }
            cardView_quatro.id -> {
                numeros.add(textView_quatro.text.toString())
                textView_primeiro_valor.append(textView_quatro.text)
            }
            cardView_cinco.id -> {
                numeros.add(textView_cinco.text.toString())
                textView_primeiro_valor.append(textView_cinco.text)
            }
            cardView_seis.id -> {
                numeros.add(textView_seis.text.toString())
                textView_primeiro_valor.append(textView_seis.text)
            }
            cardView_sete.id -> {
                numeros.add(textView_sete.text.toString())
                textView_primeiro_valor.append(textView_sete.text)
            }
            cardView_oito.id -> {
                numeros.add(textView_oito.text.toString())
                textView_primeiro_valor.append(textView_oito.text)
            }
            cardView_nove.id -> {
                numeros.add(textView_nove.text.toString())
                textView_primeiro_valor.append(textView_nove.text)
            }
            cardView_ponto.id -> {
                numeros.add(textView_um.text.toString())
                textView_primeiro_valor.append(textView_ponto.text)
            }
            cardView_igualdade.id -> {
                calculaResultado(textView_resultado)
            }
            cardView_adicao.id -> {
                numeros.add(textView_adicao.text.toString())
                textView_operador.text = textView_adicao.text
                textView_resultado.id = textView_adicao.id
            }
            cardView_subtracao.id -> {
                numeros.add(textView_subtracao.text.toString())
                textView_operador.text = textView_subtracao.text
            }
            cardView_multiplicacao.id -> {
                numeros.add(textView_multiplicacao.text.toString())
                textView_operador.text = textView_multiplicacao.text
            }
            cardView_divisao.id -> {
                numeros.add(textView_divisao.text.toString())
                textView_operador.text = textView_divisao.text
            }
            cardView_limpar.id -> {
                textView_primeiro_valor.text = ""
                textView_operador.text = ""
                textView_segundo_valor.text = ""
                textView_resultado.text = ""

            }
        }
    }

    private fun calculaResultado(textView_operador: View?) {
        when (textView_operador?.id) {
            textView_adicao.id -> {
                primeiroValor = textView_primeiro_valor.toString().toFloat()
                segundoValor = textView_segundo_valor.toString().toFloat()
                textView_resultado.text = primeiroValor.plus(segundoValor).toString()
            }
        }
    }

}
