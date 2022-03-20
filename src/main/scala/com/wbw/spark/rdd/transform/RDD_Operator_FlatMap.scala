package com.wbw.spark.rdd.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RDD_Operator_FlatMap extends App {
  val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("flatMap")
  val sc = new SparkContext(sparkConf)
  val rdd: RDD[Any] = sc.makeRDD(List(List(1, 2), 3, List(4, 5)))
  val value: RDD[Any] = rdd.flatMap {
    case list: List[_] => list
    case dat => List(dat)
  }
  value.collect().foreach(println)
  // TODO 关闭环境
  sc.stop()

}
