package com.dalimao.mytaxi.kotlintest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

fun String.lastChar() = this.get(this.length - 1)//使用import导入时 可以使用as关键字更改函数名
fun String.show() = println(this)
fun addStr(m: String) = m.get(m.length - 1)//扩展函数
class User(val name: String, val address: String)

infix fun String.insert(value: String) = value + get(length - 1)//中缀调用  infix 修饰  表达式体函数

fun String.test(): Char {//代码块体式函数

    return get(length - 1)

}

val String.lastChar: Char
    get() = get(length - 1)//扩展属性

fun saveUser(user: User): Boolean {
    var result = false
    fun valite(user: User, name: String, fieldName: String) {
        if (name.isEmpty())
            result = false
    }
    return result
}

/**
 * 函数的定义和调用
 */
class MethodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_method)
        val view: View = findViewById(R.id.tvMethod)
        val tvMethod1: View = findViewById(R.id.tvMethod1)
        view.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, PartMethodActivity().javaClass)// MethodActivity::class.java  两种方式
            startActivity(intent)
        }

        tvMethod1.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, ClassTestActivity().javaClass)// MethodActivity::class.java  两种方式
            startActivity(intent)
        }
        // initListOrMap()
        // extraMethod()
        // listArray()
        //  mapTest()
        partMethod()
        mapOf(1 to "one")
//        println("java".lastChar)
        println("kotlin" insert "Hello")
    }

    private fun partMethod() {
        val args = arrayOf("3", "6", "7", "11")
        val listOf = listOf("args", *args)

    }

    private fun mapTest() {
        mapOf<Int, String>(1 to "one")
        val regex = "java".toRegex()
        val matchEntire = regex.matchEntire("a")
        if (matchEntire != null) {
            matchEntire.destructured
        }
    }

    private fun listArray() {
        val arrayListOf = arrayListOf("1", "2", "5", "9")
        arrayListOf.last()

        arrayListOf.max()
        for (x in 0..arrayListOf.size)
            println(x)
/* for ((m, n) in arrayListOf.withIndex())*/
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