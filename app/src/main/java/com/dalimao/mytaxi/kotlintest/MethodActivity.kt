package com.dalimao.mytaxi.kotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 函数的定义和调用
 */
class MethodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_method)
        initListOrMap()
    }

    var i = 0
    private fun initListOrMap() {

        val arrayListOf = arrayListOf<String>("1", "2", "3", "4", "5", "6")
        val hashMapOf = hashMapOf<Int, String>(1 to "nacy", 2 to "alice", 3 to "three")
        for (x in arrayListOf) {
            println("结果::$x")
        }

        println("\n\n\n\n\n")
        for ((m, n) in hashMapOf) {
            println("结果::$m==$n")
        }

        val setOf = setOf(7, 3, 6, 9, 10, 23)
        println(setOf.max())
        for (x in 1..10){
            i=i++
        }
        println(i)
    }
}