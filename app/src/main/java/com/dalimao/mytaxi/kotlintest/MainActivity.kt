package com.dalimao.mytaxi.kotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dalimao.mytaxi.kotlintest.COLOR.BLUE
import com.dalimao.mytaxi.kotlintest.COLOR.RED
import com.dalimao.mytaxi.kotlintest.bean.Anim
import com.dalimao.mytaxi.kotlintest.bean.Person
import com.dalimao.mytaxi.kotlintest.bean.Rectangle

enum class COLOR(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255);

    fun rbg() = (r * 256 + g) * 256 + b
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        val person = Person()
        person.name = "bob"
        println(person.name)
        val anim = Anim("猴子", 20)

        println(anim.name)
        val rectangle = Rectangle(20, 30)
        println(rectangle.isSquare)
    }

    fun getColor(color: COLOR) = when (color) {
        RED -> "red"

        COLOR.GREEN -> "green"

        BLUE -> "blue"
    }

    val number: Int = when (0) {
        0 -> 0
        else -> 3
    }
    val color: String = when (RED) {//表达式函数
        RED, COLOR.GREEN -> "hehehe"
        else -> "hahaha"

    }
}
