package com.wbw.study.chapt3

/**
 * scala采用特质trait来代替interface，trait类似于Java的抽象类
 * java接口直接当作trait使用
 * 出现继承冲突时，当冲突的两个trait没有任何关系，直接重写冲突方法
 * 当冲突的两个trait继承自相同的trait，采用特质叠加的策略
 * 特质叠加 就是将冲突方法叠加在一起
 * 可以通过super[]来增加约束，例如super[Category].des()
 */
trait Ball {
  def des():String = {
    "ball"
  }
}
trait Color extends Ball {
  override def des():String = {
    "blue-" + super.des()
  }
}
trait Category extends Ball {
  override def des(): String = {
    "foot-" + super.des()
  }
}
//继承第一个特质使用extends，之后使用with
class MyBall extends Category with Color {
  override def des(): String = {
    "my ball is " + super.des()
  }
}
object Test{
  def main(args: Array[String]): Unit = {
    //特质叠加顺序
    println(new MyBall().des())
  }
}
object Test20 extends App {
  println("xxxxxxxxxxxxx")
}
