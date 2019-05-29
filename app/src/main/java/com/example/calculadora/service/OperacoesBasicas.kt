package com.example.calculadora.service

import com.example.calculadora.service.interfaces.Calculadora
import net.objecthunter.exp4j.ExpressionBuilder

class OperacoesBasicas: Calculadora {

    override fun calcule(expressao: String): Double {
        return ExpressionBuilder(expressao).build().evaluate()
    }
}