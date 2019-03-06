package com.dalimao.mytaxi.kotlintest.classUI

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dalimao.mytaxi.kotlintest.R

fun sum(x: Int, y: Int): Int {
    println("hehehhe")
    return x + y
}

val arm = { x: Int, y: Int -> x + y }

data class People(val name: String, val age: Int)
data class V(val name: String) {
    fun sum(x: Int, y: Int) {
        println("$name 计算的总和：${x + y}")
    }
}

class LimbdaActviity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_method)
        val sum = sum(2, 4)

        println(sum)
        val listOf = arrayListOf(1, 2, 3, 54, 5)

        val x = listOf.maxBy { it }
        println(x)
        val people1 = People("alibe", 23)
        val people2 = People("bob", 24)
        val peopleList = arrayListOf(people1, people2)
        val getAge = { p: People -> p.age }

        val maxAge = peopleList.maxBy(getAge)
        println(maxAge)
        val su = { x: Int, y: Int -> x + y }
        println(su(4, 8))

        val age = getAge(people2)
        println("当前的people年龄$age")
        val vSum = { v: V, x: Int, y: Int -> v.sum(x, y) }
        vSum(V("heheh"), 3, 5)

        val testSum = V::sum//成员引用   类名::成员
        testSum(V("sum"), 6, 7)

        val filter = peopleList.filter { p: People -> p.age > 20 }
        val filterList = peopleList.filter { it.age > 22 }
        println(filter == filterList)
        println(filter.hashCode())
        println(filterList.hashCode())
    }
}