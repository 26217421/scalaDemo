package com.wbw.spark.core.rdd.file

import org.apache.spark.{SparkConf, SparkContext}

object RDD_FIle_Save extends App {
  val Conf = new SparkConf().setMaster("local").setAppName("fileSave")
  val sc = new SparkContext(Conf)
  val rdd = sc.makeRDD(
    List(
      ("a", 1),
      ("b", 2),
      ("c", 3)
    )
  )

  rdd.saveAsTextFile("output1")
  rdd.saveAsObjectFile("output2")
  rdd.saveAsSequenceFile("output3")

  sc.stop()
}
