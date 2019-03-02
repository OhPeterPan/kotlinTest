package com.dalimao.mytaxi.kotlintest.classUI

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.AbsListView
import android.widget.ListView
import com.dalimao.mytaxi.kotlintest.R

interface Clickable {
    fun click()
    fun showOff() = println("一切结束了")
    fun open()
    fun close() = println("click close")
}

interface Focusable {
    fun focus()
    fun showOff() = println("一切结束了")
    fun open()
    fun close() = println("focus close")
}

class Button : Clickable, Focusable {
    override fun close() {
        super<Clickable>.close()//调用接口的实现
        super<Focusable>.close()
    }
//    override fun close() = super<Clickable>.close()

    override fun open() = println("自己好傻哦，这是必然要会的")

    override fun focus() = println("我是focus")

    override fun showOff() = println("当要实现的两个接口都含有这个方法(带方法体的方法)时，子类必须实现")

    override fun click() = println("我是点击")
}

//kotlin 禁止高可见类型的类或者函数去引用低可见性类型的函数或者类
internal class Test {
    fun getTest() = println("hehehe")
    fun demo() = println("hahahaha")
}

internal fun Test.charTest() {
    getTest()
    demo()
}

open class User(open val name: String)

data class TwitterUser(override val name: String) : User(name)

open class Person(name: String) {
    val name = name
}

interface Book {
    val name: String
}

class Book1(override val name: String) : Book
class Book2 : Book {
    override val name: String
        get() = "hahahha"
}

class Book3(val email: String = "163289@163.com") : Book {
    override val name: String
        get() = email.substring(2)
}

//对象声明
object Payroll {
    val list = arrayListOf<String>()
    var name: String? = null
    fun test(email: String) = email.substringBefore("@")
}

//伴生对象
class A {
    companion object {
        fun yes() {
            println("哈哈哈哈，伴生对象的使用")
            val a = A()
            a.test()
        }
    }

    private constructor()

    private fun test() {
        println("哈哈哈哈，我是容器类的方法")
    }
}

data class Animal private constructor(val name: String) {
    companion object {
        //无名字的伴生对象
        fun dog() {
            val animal = Animal("我是一只狗")
            println(animal)
        }

        fun cat() {
            val animal = Animal("我是一只猫")
            println(animal)
        }
    }
}

class ClassTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_class)

        val twitterUser = TwitterUser("Bob")
        println(twitterUser)
        val user = twitterUser.copy(name = "hehehhe")//需要类使用data修饰
        println(user)
        A.yes()
        Payroll.test("156382765483@163.com")
        println("我是对象声明的值${Payroll.test("156382765483@163.com")}")

        Animal.dog()
        Animal.cat()

//object关键字可以用来改变java的匿名内部类的写法
        val recyclerView = RecyclerView(this)
        recyclerView.setRecyclerListener {

        }
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            //使用object关键字改变java匿名内部类的写法
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
        val listView = ListView(this)
        listView.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {

            }

            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {

            }

        })
    }
}
