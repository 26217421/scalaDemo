package com.wbw.study.chapt4

import scala.collection.mutable

object TestMap {
  def main(args: Array[String]): Unit = {
    val map = mutable.Map("a"->1, "b"->2, "c"->3)
    map.+=("d"->4)
    val mayInt : Option[Int] = map.put("a",4)
    println(mayInt.getOrElse(0))
    map.-=("b","c")
    map.update("d",5)
    map("d")=5
    map.foreach((kv) =>{println(kv)})
  }
}
