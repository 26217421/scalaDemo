package com.wbw.study.chapt1

/**
 * scala一切数据皆是对象，都是Any的子类
 * scala数据类型分两类数值类型（AnyVal）和引用类型（AnyRef）
 * scala支持隐式转换同Java
 * Unit是AnyVal的子类型。 Unit类型只有一个值， () ，并且它不由底层运行时系统中的任何对象表示。 返回类型为Unit 的方法类似于声明
     为void的 Java 方法
 *Null是一个类型 只有一个对象null，是所有引用类型(AnyRef)的子类 所以不能赋值给值类型
 * Nothing,所有数据类型的子类，主要用于函数没有明确返回值类型时。(兼容性)
 */
object TestType {
  /**
   * 整数类型Byte(1)、Short(2)、Int(4)、Long(8)
   * 浮点类型Float(4) Double(8)
   * 字符类型Char(2)
   * 布尔类型Boolean(1)
   */
  def main(args: Array[String]): Unit = {
    //强制类型转换
    var num: Int = 2.7.toInt
    //强制类型转换溢出
    var n : Int = 130
    var b : Byte = n.toByte
    println(b)

    println(num)
    //基本数值类型转String类型
    var 石头人 : String = true + ""
    var str2 : String = 2.4 + ""
    println(石头人)
    println(str2)
    //String类型转基本数据类型
    var s1 : String = "64"
    var n1 : Byte = s1.toByte
    var n2 : Short = s1.toShort
    var n3 : Int = s1.toInt
    var n4 : Long = s1.toLong
    println(n1)
    println(n2)
    println(n3)
    println(n4)
  }

}
