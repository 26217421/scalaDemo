package com.wbw.study.chapt1

object TestVar {
  def main(args: Array[String]): Unit = {
    //声明变量时类型可以省略 编译器自动推导：类型推导
    var age = 18
    age = 30
    //类型确定后不能更改 即强数据类型语言
    //age = "wbw"//wrong
    //声明变量时必须初始化
    //var name //wrong
    //声明变量时可用var 或者val（java final）修饰  var修饰的变量可改，val修饰的变量不可改。
    var num1 = 10
    val num2 = 20
    num1 = 30
    //num2 = 30//wrong
    //var修饰的对象引用可以改变，val 修饰的对象则不可改变，但状态（值） 却是可以改变的。
    var p1 = new Person()
    p1.name = "as"
    p1 = null
    val p2 = new Person()
    p2.name = "qw"
    //p2 = null//wrong
  }

}
class Person(){
  var name: String = "abc"
}
