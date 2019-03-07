package com.dalimao.mytaxi.kotlintest.classUI

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Toast
import com.dalimao.mytaxi.kotlintest.R
import kotlinx.android.synthetic.main.activity_main.*

//kotlin中，除了循环结构，大都是表达式
//lambda表达式学习
class ListLambdaActivity : AppCompatActivity() {
    data class Person(val name: String, val age: Int)

    //显示的将lambda表达式转换成函数式接口
    val listener = View.OnClickListener { v ->
        val result = when (v.id) {
            R.id.textView -> "textview"
            else -> throw UnsupportedOperationException()
        }
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val person1 = Person("bob", 29)
        val person2 = Person("alice", 22)
        val person3 = Person("lilei", 29)
        val person4 = Person("hanmei", 25)
        val person5 = Person("mam", 29)
        val person6 = Person("amani", 30)
        val list = arrayListOf(person1, person2, person3, person4, person5, person6)
        /*      val count = list.count { it.age == 29 }
              println(count)
              println(list.size)
              println(list.map { it.name })//[bob, alice, lilei, hanmei, mam, amani]
              println(list.map { it.age * 2 })
              println(list.filter { it.age > 24 })
              println(list.all { it.age == 29 })//判断是否所有的person对象的年龄都等于29  返回值是boolean类型
              println(list.any { it.age > 27 })//判断至少有一个对象的年龄大于27 返回值是boolean类型
              println(list.find { it.age == 29 })//返回第一个满足的对象
              println(list.maxBy { it.age })//返回第一个满足的对象
              val groupBy = list.groupBy { it.age }//根据对象的年龄分组
              println(groupBy)
              val strList = arrayListOf("abc", "fgh")
              println(strList.toList())//   [abc, fgh]
              println(strList.map { it.toList() })//[[a, b, c], [f, g, h]]
              println(strList.flatMap { it.toList() })//    [a, b, c, f, g, h]*/
        val result = list.asSequence().map { it.name }
                .filter { it.startsWith(prefix = "A", ignoreCase = true) }.toList()
        println(result)
//生成自然数列
        val generateSequence = generateSequence(0) { it + 1 }
        val takeWhile = generateSequence.takeWhile { it <= 100 }
        println(takeWhile.sum())
        textView.setOnClickListener(listener)

        //File("").parentFile
        /*       val recyclerView = RecyclerView(this)
               recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {//改变写法的匿名内部类

               })
               val textView = TextView(this)
               textView.setOnClickListener(object : View.OnClickListener {
                   override fun onClick(v: View?) {

                   }
               })
               textView.setOnClickListener { v:View -> println("hahahaha") }*/
        //改变写法的匿名内部类
        /*      textView.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                  override fun onGlobalLayout() {
                      textView.viewTreeObserver.removeOnGlobalLayoutListener(this)

                  }
              })*/
        val globalListener = ViewTreeObserver.OnGlobalLayoutListener {
           // println("打印的GlobalListener:${this}")//这里的this指代的是包围它的类
        }
        textView.viewTreeObserver.addOnGlobalLayoutListener(globalListener)

        //带接受者的lambda
        val alphabet = alphabet()
        println(alphabet)

    }

    private fun alphabet(): String {
        val stringBuilder = StringBuilder()
        return with(stringBuilder, {
            for (result in 'A'..'Z') {
                append(result)
            }
            this.toString()
        })
    }
}