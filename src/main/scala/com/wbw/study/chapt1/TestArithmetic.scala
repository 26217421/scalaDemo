package com.wbw.study.chapt1

/**
 * scala运算符本质 所有运算符都是方法
 * 1）当调用对象的方法时，点.可以省略
 * 2）如果函数参数只有一个，或者没参数，()可以省略
 * scala没有++ -- 可以通过+= -=替代
 */
object TestArithmetic {
  def main(args: Array[String]): Unit = {
    //1）对于除号"/"整数除同java小数除保留小数部分
    var r1 : Double = 10 / 3
    println(r1)
    var r2 : Double = 10.0 / 3
    println(r2)
    var r3 : Double = 10 / 3.0
    println(r3)
    //scala==类似java equals()方法 eq方法类似java==
    val s1 = "abc"
    val s2 = new String("abc")
    println(s1.equals(s2))
    println(s1 == s2)
    println(s1.eq(s2))
    var i : Int = 1.+(1)

    println(1.toString())
    println(1 toString())
    println(1 toString)


  }
}
