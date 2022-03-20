package com.wbw.spark.rdd.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RDD_Operator_Coalesce extends App {
  val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("reduceTheNumberOfPartitions")
  val sc = new SparkContext(sparkConf)
  val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4,5,6),numSlices = 3)

  /**
   * 减少分区个数
   * 第一个参数表示:分区的个数
   * 第二个参数表示:是否均衡分配
   *              false:不均衡，那么之前的分区数据不会分开  (1,2) (3,4) (5,6)三个分区变成两个分区--->(1,2) (3,4,5,6)
   *              true:调用shuffle打乱数据重新分配    (1,2) (3,4) (5,6)三个分区变成两个分区,数据会打乱，重新改分配 ---->(1,4,5) (2,3,6)
   */
  val coalesceRDD: RDD[Int] = rdd.coalesce(2, true)
  coalesceRDD.saveAsTextFile("output")
  // TODO 关闭环境
  sc.stop()
}
