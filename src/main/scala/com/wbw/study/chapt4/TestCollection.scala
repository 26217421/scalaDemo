package com.wbw.study.chapt4

object TestCollection {
  def main(args: Array[String]): Unit = {
    val list1:List[Int] = List(1,2,3,4,5,6,7)
    val list2:List[Int] = List(4,5,6,7,8,9,10)
    println(list1.head)
    println(list1.tail)
    println(list1.last)
    println(list1.init)
    println(list1.reverse)
    println(list1.take(3))
    println(list1.takeRight(3))
    println(list1.drop(3))
    println(list1.dropRight(3))
    println(list1.union(list2))
    println(list1.intersect(list2))
    println(list1.diff(list2))
    println(list1.zip(list2))
    list1.sliding(2,5).foreach(println)
  }
}
object TestCollection2 extends App {
  val list :List[Int] = List(1,2,3,4,5,6,7,8,9)
  val nestedList :List[List[Int]] = List(List(1,2,3),List(4,5,6),List(7,8,9))
  val wordList :List[String] = List("hello world", "hello jlu", "hello scala")
  //过滤
  println(list.filter(x => x%2 == 0))
  println(list.map(x => x+1))
  println(nestedList.flatten)
  println(wordList.flatMap(x => x.split(" ")))
  println(list.groupBy(x => x %2))
}

object TestReduce extends App {
  val list = List(1,2,3,4)
  val i:Int = list.reduce( (x,y) => x-y)
  println("i = " + i)
  val i2 = list.reduceRight( (x,y) => x-y)
  println("i2 = " + i2)
}
