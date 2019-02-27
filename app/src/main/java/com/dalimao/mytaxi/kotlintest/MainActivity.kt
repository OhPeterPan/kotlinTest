package com.dalimao.mytaxi.kotlintest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.dalimao.mytaxi.kotlintest.COLOR.BLUE
import com.dalimao.mytaxi.kotlintest.COLOR.RED
import com.dalimao.mytaxi.kotlintest.bean.Anim
import com.dalimao.mytaxi.kotlintest.bean.Person
import com.dalimao.mytaxi.kotlintest.bean.Rectangle
import java.util.*

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
        val view: View = findViewById(R.id.textView)

        view.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, MethodActivity().javaClass)// MethodActivity::class.java  两种方式
            startActivity(intent)
        }

        // initData()
        //whileTest()
        //whileTestTwo()
        forMap()
    }

    private fun forMap() {
        val treeMap = TreeMap<Char, String>()

        for (c in 'a'..'f') {//关键词in迭代区间或者集合
            val binary = Integer.toBinaryString(c.toInt())
            treeMap[c] = binary
        }
        for ((x, y) in treeMap) {
            println("$x==$y")
        }
    }

    private fun whileTestTwo() {
        for (i in 100 downTo 0 step 3) {// 100-0 包含结束值
            println("zouxiaqu$i")
        }
        println("Hello,World".lastChar())
    }

    private fun whileTest() {
        for (i in 0..100 step 2) { //0..100 区间的概念
            //println("继续$i")
            println(fizzBuzz(i))
        }
    }

    fun fizzBuzz(i: Int) = when {
        i % 2 == 0 -> "恭喜你"
        else -> "你完犊子了"
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
