package com.dalimao.mytaxi.kotlintest.bean

class Person() {
    val age: Int = 0
    var name: String? = null
}

class Anim(val name: String, val age: Int) {
    var isBig: Boolean = false
}

class Rectangle(private val width: Int, private val height: Int) {

    val isSquare
        get() = width == height
}