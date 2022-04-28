package com.wbw.spark.core.rdd.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RDD_Operator_OuterJoin extends App {
  val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
  val sc = new SparkContext(sparkConf)

  // TODO 算子 - (Key - Value类型)

  val rdd1 = sc.makeRDD(List(
    ("a", 1), ("b", 2)//, ("c", 3)
  ))

  val rdd2 = sc.makeRDD(List(
    ("a", 4), ("b", 5),("c", 6)
  ))
  //val leftJoinRDD = rdd1.leftOuterJoin(rdd2)
  val rightJoinRDD: RDD[(String, (Option[Int], Int))] = rdd1.rightOuterJoin(rdd2)

  //leftJoinRDD.collect().foreach(println)
  rightJoinRDD.collect().foreach(println)



  sc.stop()
}
