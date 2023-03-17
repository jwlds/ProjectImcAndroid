package br.com.puc.imc

import kotlin.math.pow

class Person( val personWeight: Double, val personHeight: Double) {

     fun calImc(): Double  = personWeight / personHeight.pow(2)

}