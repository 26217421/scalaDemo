package com.wbw.study.chapt4

import scala.collection.mutable.ListBuffer


object TestList {
  //List默认为不可变集合
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1,2,3,4,5)
    val list5 = 1 :: (2 :: (3 :: (4 :: Nil)))
    //遍历
    list.foreach(print)
    println()
    //list增加数据 ::运算规则从右到左
    val list1 = 6::list
    //添加到第一个位置
    val list2 = list.+:(5)
    //集合间合并
    val list3 = List(7,8,9)
    val list4 = list3:::list1
    list4.foreach(print)
    //取指定数据
    println(list(0))
    println()
    list5.foreach(print)
  }
}
object TestListBuffer {
  def main(args: Array[String]): Unit = {
    val buffer = ListBuffer(1,2,3,4)
    buffer.+=(5)
    buffer.append(6)
    buffer.insert(1,2)

    buffer.foreach(println)
    buffer(1)=6
    buffer.-(5)
    buffer.-=(5)
    buffer.remove(5)
  }
}
