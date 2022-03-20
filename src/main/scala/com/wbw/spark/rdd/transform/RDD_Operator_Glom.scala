package com.wbw.spark.rdd.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * 计算所有分区最大值求和
 */
object RDD_Operator_Glom extends App {
  val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("getMaxSum")
  val sc = new SparkContext(sparkConf)
  // 【1，2】【3，4】
  // 【2】【4】
  // 6
  val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4),numSlices = 2)
  // 变成数组
  val glomRDD: RDD[Array[Int]] = rdd.glom()
  // 取最大值
  val maxRDD: RDD[Int] = glomRDD.map(
    array => {
      array.max
    }
  )
  println(maxRDD.collect().sum)
  // TODO 关闭环境
  sc.stop()

}
