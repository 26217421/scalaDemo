package com.wbw.study.chapt4

/**
 * 并行集合
 */
object TestPar {
  def main(args: Array[String]): Unit = {
    val result1 = (0 to 100).map(_ =>
      Thread.currentThread.getName)
    val result2 = (0 to 10).par.map(_ =>
      Thread.currentThread.getName)
    println(result1)
    println(result1.size)
    println(result2)
    println(result2.size)

  }
}
