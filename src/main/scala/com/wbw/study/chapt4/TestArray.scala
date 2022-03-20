package com.wbw.study.chapt4

import scala.collection.mutable.ArrayBuffer

/**
 * scala集合： Set Map Seq 都扩展自Iterable特质
 * 操作集合中，不可变用符号，可变用方法
 */

/**
 * 不可变数组
 */
object TestArray extends App {
  //数组定义
  val arr01 = new Array[Int](4)
  var arr02 = Array(0,2,"asd")
  println(arr01.length)
  //数组赋值
  arr01(3) = 10
  arr01.update(0,1)
  //遍历数组
  //查看数组
  println(arr01.mkString(","))
  //普通遍历
  for(i <- arr01) {
    println(i)
  }
  //简化便利
  def printX(elem:Int):Unit = {
    print(elem)
  }
  arr01.foreach(printX)
  arr01.foreach(print)
  //增加元素(实际是创建新的数组)
  val ints: Array[Int] = arr01 :+5
  println(ints.mkString)
  //多维数组
  val arr03 = Array.ofDim[Int](3,4)
  for (i <- arr03) {
    for (j <- i) {
      print(j + " ")
    }
  }
}

/**
 * 可变数组
 */
object TestArrayBuffer {
  def main(args: Array[String]): Unit = {
    val arr01 = ArrayBuffer[Any](1,2,3)
    println("hash = " + arr01.hashCode())
    //增加元素
    arr01.+=(4)
    arr01.append(5,6)
    arr01.insert(0,7,8)
    println("hash = " + arr01.hashCode())
    arr01(2) = 9
    arr01.foreach(print)
    val newArr1 = arr01.toArray//返回不可变数组，array1不变
    val newArr2 = newArr1.toBuffer//返回可变数组，newArr2不变
  }
}