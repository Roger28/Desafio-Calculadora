package com.example.calculadora.service

import net.objecthunter.exp4j.ExpressionBuilder

object Calculadora {

    fun calcule(expressao: String): Double {
        return ExpressionBuilder(expressao).build().evaluate()
    }
}