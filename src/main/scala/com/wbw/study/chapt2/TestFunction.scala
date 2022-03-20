package com.wbw.study.chapt2

import org.junit.Test

/**
 * scala 是完全的函数式编程，万物皆函数
 * 函数的本质 可以当作值传递
 * 函数为完成某一功能的程序语句的集合 方法为类中的函数
 * 函数可以嵌套定义 方法可以重载和重写 但函数没有重载和重写的概念
 */
object TestFunction {
  def main(args: Array[String]): Unit = {
    main2()
    def foo(): Unit = {
      println("spark...")
    }
    //（1）return可以省略，Scala会使用函数体的最后一行代码作为返回值
    //（2）如果函数体只有一行代码，可以省略花括号
    //（3）返回值类型如果能够推断出来，那么可以省略（:和返回值类型一起省略）
    //（4）如果有return，则不能省略返回值类型，必须指定
    //（5）如果函数明确声明unit，那么即使函数体中使用return关键字也不起作用
    //（6）Scala如果期望是无返回值类型，可以省略等号
    //（7）如果函数无参，但是声明了参数列表，那么调用时，小括号，可加可不加
    //（8）如果函数没有参数列表，那么小括号可以省略，调用时小括号必须省略
    //（9）如果不关心名称，只关心逻辑处理，那么函数名（def）可以省略 （匿名函数）


    /**
     * 函数作为值传递
     */
    def fo1():Int = {
      println("foo")
      1
    }
    val f = fo1
    println(f)
    val f1 = fo1 _
    foo()
    f1()
    //如果明确变量类型，不是用下划线也可以讲函数作为整体传递给变量
    var fun:()=>Int = fo1

    /**
     * 函数作为参数传递
     */
    def f2(f:(Int,Int) => Int): Int = {
      f(2,4)
    }
    def add(a: Int, b: Int): Int = a + b
    println(f2(add))
    /**
    * 函数可以作为函数返回值返回
    *
    */
    def f3() = {
      def f4() = {

      }
      f4 _
    }
    val ff = f1
    ff()
    //f1()()
  }

  /**
   * 匿名函数
   * 没有名字的函数就是匿。
   * (x:Int )=> {函数体}
   */
  def main2(): Unit = {
    def operation(arr: Array[Int], op: Int => Int) = {
      for (elem<- arr) yield op(elem)
    }
    def op(ele: Int): Int = {
      ele + 1
    }
    val arr = operation(Array(1,2,3,4,5), op)
    println(arr.mkString(","))
    //使用匿名函数
    val arr1 = operation(Array(1,2,3,4,5), (ele: Int) => {ele + 1})
    println(arr1.mkString(" - "))
    //(1)参数的类型可以省略，根据形参自动推导
    val arr2 = operation(Array(1,2,3,4,5), (ele) => {ele + 1})
    println(arr2.mkString(","))
    //(2)只有一个参数省略后，圆括号可以省略
    val arr3 = operation(Array(1,2,3,4,5), ele => {ele + 1})
    println(arr3.mkString(","))
    //(3)匿名函数只有一行 则大括号也可以省略
    val arr4 = operation(Array(1,2,3,4,5), ele => ele + 1)
    println(arr4.mkString(","))
    //(4)如果参数只出现一次，省略参数后可以用_来代替
    val arr5 = operation(Array(1,2,3,4,5), _+ 1)
    println(arr5.mkString(","))
  }
  def main3(): Unit = {
    def calculator(a: Int, b: Int, op: (Int, Int) => Int): Int = {
      op(a,b)
    }
    //标准版
    println(calculator(2, 3, (x: Int, y: Int)=> {x+y}))
    //匿名函数只有一行 则大括号也可以省略
    println(calculator(2, 3, (x: Int, y: Int)=> x+y))
    //(1)参数的类型可以省略，根据形参自动推导
    println(calculator(2, 3, (x, y)=> x+y))
    //如果参数只出现一次，省略参数后可以用_来代替
    println(calculator(2, 3, _+_))

  }
}
