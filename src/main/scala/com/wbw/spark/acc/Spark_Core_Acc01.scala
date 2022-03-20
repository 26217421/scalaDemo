package com.wbw.spark.acc

import org.apache.spark.{SparkConf, SparkContext}

object Spark_Core_Acc01 extends App {
  val Conf = new SparkConf().setMaster("local").setAppName("")
  val sc = new SparkContext(Conf)

  val rdd = sc.makeRDD(List(1,2,3,4,5))
  var sum = sc.longAccumulator("sum")
  val sumAcc = sc.longAccumulator("sum1")

  //sc.doubleAccumulator
  //sc.collectionAccumulator

  rdd.foreach(
    num => {
      sum.add(num)
    }
  )
  val mapRDD = rdd.map(
    num => {
      // 使用累加器
      sumAcc.add(num)
      num
    }
  )
  println("sum = " + sum)
  //转换算子中调用累加器，如果没有行动算子的话，那么不会执行
  mapRDD.collect()
  println("sum1 = " + sumAcc)

  sc.stop()
}
