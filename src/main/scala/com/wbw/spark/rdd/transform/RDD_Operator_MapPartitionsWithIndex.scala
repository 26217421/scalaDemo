package com.wbw.spark.rdd.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RDD_Operator_MapPartitionsWithIndex extends App {
  val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("printData")
  val sc = new SparkContext(sparkConf)
  val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4),numSlices = 2)
  val value: RDD[(Int, Int)] = rdd.mapPartitionsWithIndex(
    (index, iter) => {
      iter.map(
        num => {
          (index, num)
        }
      )
    }
  )
  value.collect().foreach(println)
  // TODO 关闭环境
  sc.stop()

}
