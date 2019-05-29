package com.example.calculadora.entity

class Expressao {
    var lastDigitWasNumeric: Boolean = false
    var isInvalidOperation: Boolean = false
    var lastDigitWasDecimalPoint: Boolean = false
    lateinit var formula: String
}