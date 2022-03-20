package com.wbw.spark.rdd.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RDD_Operator_Map extends App {
  val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("getUrl")
  val sc = new SparkContext(sparkConf)

  val rdd: RDD[String] = sc.textFile("input/apache.log")
  val value: RDD[String] = rdd.map({
    line => {
      line.split(" ")(6)

    }
  })
  value.collect().foreach(println)
  sc.stop()
}
