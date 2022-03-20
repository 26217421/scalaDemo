package com.wbw.study.chapt1

import scala.io.StdIn

object TestInput {
  def main(args: Array[String]): Unit = {
    println("input your name:")
    var name = StdIn.readLine()
    println("input your age")
    var age = StdIn.readShort()
    println("input your salary")
    var sal = StdIn.readDouble()
    println("name=" + name + "\n" + "age=" + age + "\n" + "sal=" + sal)
  }
}
