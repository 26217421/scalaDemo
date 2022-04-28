package com.wbw.spark.core.rdd.transform

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object RDD_Operator_CoGroup extends App {
  val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
  val sc = new SparkContext(sparkConf)

  // TODO 算子 - (Key - Value类型)

  val rdd1 = sc.makeRDD(List(
    ("a", 1), ("b", 2)//, ("c", 3)
  ))

  val rdd2 = sc.makeRDD(List(
    ("a", 4), ("b", 5),("c", 6),("c", 7)
  ))

  // cogroup : connect + group (分组，连接)
  val cgRDD: RDD[(String, (Iterable[Int], Iterable[Int]))] = rdd1.cogroup(rdd2)

  cgRDD.collect().foreach(println)


  sc.stop()

}
