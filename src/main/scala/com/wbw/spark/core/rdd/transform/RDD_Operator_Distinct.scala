package com.wbw.spark.core.rdd.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RDD_Operator_Distinct extends App {
  val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("deDuplication")
  val sc = new SparkContext(sparkConf)
  val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 1, 2, 3, 4))

  /**
   * 数据去重
   * 底层原理:
   *  map(x => (x, null)).reduceByKey((x, _) => x, numPartitions).map(_._1)
   *  1、 1, 2, 3, 4, 1, 2, 3, 4
   *  2、(1,null),(2,null),(3,null),(4,null),(1,null),(2,null),(3,null),(4,null)
   *  3、(1,null),(2,null),(3,null),(4,null)
   *  4、1, 2, 3, 4
   */
  rdd.distinct().collect().foreach(println)

  // TODO 关闭环境
  sc.stop()

}
