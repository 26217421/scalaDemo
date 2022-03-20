package com.wbw.spark.rdd.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
//从服务器日志数据 apache.log 中获取 2015 年 5 月 17 日的请求路径
object RDD_Operator_Filter extends App {
  val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("getFilterPath")
  val sc = new SparkContext(sparkConf)

  val rdd: RDD[String] = sc.textFile("input/apache.log")
  val timeRDD: RDD[String] = rdd.filter(
    line => {
      val time: String = line.split(" ")(3)
      time.startsWith("17/05/2015")
    }
  )
  timeRDD.collect().foreach(println)
  // TODO 关闭环境
  sc.stop()

}
