package com.wbw.spark.core.rdd.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RDD_Operator_MapPartitions extends App {
  val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("getMax")
  val sc = new SparkContext(sparkConf)
  val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5),numSlices = 2)
  val value: RDD[Int] = rdd.mapPartitions(
    iter => {
      List(iter.max).iterator
    }
  )
  value.collect().foreach(println)

  sc.stop()
}
