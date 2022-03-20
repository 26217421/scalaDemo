package com.wbw.study.chapt4

import scala.collection.mutable

object TestSet {
  def main(args: Array[String]): Unit = {
    val set = Set(1,2,3,4,5)
    val set1 = Set(1,2,3,4,6,5,5,8,8,1)
    set1.foreach(print)
    val mset = mutable.Set(1,2,3,4,5,6)
    mset += 8
    val ints = mset.+(9)
    println(ints)
    println("set2=" + mset)
    mset-=(5)
    mset.foreach(print)
    println()
    println(mset.mkString(","))

  }

}
