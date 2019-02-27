package com.dalimao.mytaxi.kotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dalimao.mytaxi.kotlintest.bean.ClasssTest


fun String.lastChars(): Char = get(length - 1)


fun ClasssTest.validateBeforeSSave() {
    if (name.isEmpty()) {
        throw IllegalArgumentException("不能save这个用户$name")
    }
}

class PartMethodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part_method)
        val classsTest = ClasssTest("haha", "河南", 12)
        val user = ClasssTest("", "河南", 12)

        try {
            user.validateBeforeSSave()
        } catch (e: Exception) {
            print("报错${e.message}")
        }
    }
}
