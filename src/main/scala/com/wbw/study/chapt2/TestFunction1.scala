package com.wbw.study.chapt2

import scala.collection.mutable.ArrayBuffer

/**
 * 模拟Map映射、Filter过滤、Reduce聚合
 */
object TestFunction1 {
  def main(args: Array[String]): Unit = {
    def map(arr: Array[Int], op: Int=> Int) = {
      for(elem <- arr) yield op(elem)
    }
    val arr = map(Array(1,2,3,4,5), (s:Int)=>{
      s*s
    })
    println(arr.mkString(","))
    def filter(arr:Array[Int], op:Int=>Boolean)  ={
      var arr1:ArrayBuffer[Int] = ArrayBuffer[Int]()
      for(elem<- arr if op(elem)) {
        arr1.append(elem)
      }
      arr1.toArray
    }
    var arr1 = filter(Array(1,2,3,4,5), _%2 == 1)
    println(arr1.mkString(","))
    def reduce(arr:Array[Int], op:(Int,Int)=>Int) = {
      var init: Int = arr(0)
      for(elem<- 1 until arr.length) {
        init = op(init, elem)
      }
      init
    }
    val arr2 = reduce(Array(1,2,3,4,5), _*_)
    println(arr2)
  }

}
