package com.dalimao.mytaxi.kotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

fun String.lastChar() = this.get(this.length - 1)//使用import导入时 可以使用as关键字更改函数名
fun String.show() = println(this)
/**
 * 函数的定义和调用
 */
class MethodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_method)
        // initListOrMap()
        extraMethod()
    }

    private fun extraMethod() {
        println("Kotlin".lastChar())
        "JAVA".show()
    }

    var i = 0
    private fun initListOrMap() {

        val arrayListOf = arrayListOf("1", "2", "3", "4", "5", "6")
        val hashMapOf = hashMapOf(1 to "nacy", 2 to "alice", 3 to "three")
        for (x in arrayListOf) {
            println("结果::$x")
        }

        println("\n\n\n\n\n")
        for ((m, n) in hashMapOf) {
            println("结果::$m==$n")
        }

        val setOf = setOf(7, 3, 6, 9, 10, 23)

        for (x in 1..10) {
            i = i++
        }
        println(i)
    }
}