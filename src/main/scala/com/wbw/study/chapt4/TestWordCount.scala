package com.wbw.study.chapt4

object TestWordCountS {
  def main(args: Array[String]): Unit = {
    val stringList = List("Hello Scala HBase Kafka" ,"Hello Scala HBase", "Hello Scala", "Hello")
    val wordList: List[String] = stringList.flatMap(str => str.split(" "))

    val wordToWordsMap: Map[String, List[String]] = wordList.groupBy(word =>word)
    val wordToCountMap: Map[String, Int] = wordToWordsMap.map(x=>(x._1,x._2.size))
    val sortList = wordToCountMap.toList.sortWith{
      (left, right) => {
        left._2 > right._2
      }
    }
    val resultList = sortList.take(3)
    println(resultList)
  }
}

object TestWordCountH1 extends App {

}
