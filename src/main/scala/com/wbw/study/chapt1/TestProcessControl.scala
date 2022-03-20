package com.wbw.study.chapt1

import scala.io.StdIn
import scala.language.postfixOps
import scala.util.control.Breaks
import scala.util.control.Breaks.breakable
/**
 * scala for循环以符号 <- 提供生成器
 * 以 <- 变量表达式的形式，提供多个for循环，以;隔开
 * 多个表达式以;隔开逻辑 也可以花括号替代圆括号 一行一个表达式
 * 可以引入任意多的定义，并也可以再引入再循环中使用的变量
 * scala循环可以返回值 使用yield关键字 将每次循环处理的结果放入一个vector集合中

 * scala while循环与java类似 没有返回值 结果为Unit类型

 * scala没有break continue 而是使用breakable控制结构以函数式的风格实现循环中断的功能
 */
object TestProcessControl {
  def main(args: Array[String]): Unit = {
    val age = StdIn.readInt()
    //scala中if else有返回值，返回值为满足条件的最后一行代码内容
    val res :String = if (age < 18) {
      "青年"
    } else if(age>=18 && age<30) {
      "中年 "
    }else {
      "老年 "
    }
    //返回值类型不一致取共同祖先
/*    val res :Any = if (age < 18) {
      "青年"
    } else if(age>=18 && age<30) {
      "中年 "
    }else {
      100
    }*/
    println(res)


    //范围数据循环to 前后闭合
    for(i <- 1 to 3) {
      print(i + " ")
    }
    println()
    //范围数据循环until 前闭后开
    for(i <- 1 until  3) {
      print(i + " ")
    }
    println()
    //循环守卫
    for(i <- 1 to 3 if i != 2) {
      print(i + " ")
    }
    println()
    //循环步长
    for(i <- 1 to 10 by 2) {
      print(i + " ")
    }
    println()
    //嵌套循环
    for{i <- 1 to 3
        j <- 1 to 3
        } {
      print(i + " " + j + " ")
    }
    println()
    //循环返回值
    val res1 = for (i <- 1 to 10) yield {
      i * 2
    }
    println(res1)
    //倒序循环
    for(i <- 1 to 10 reverse) {
      print(i + " ")
    }
    println()

    breakable {
      for(i <- 1 to 10) {
        print(i + " ")
        if(i == 7) Breaks.break
      }
    }

  }
}
