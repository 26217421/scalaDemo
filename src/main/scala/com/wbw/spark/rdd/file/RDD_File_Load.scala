package com.wbw.spark.rdd.file

import org.apache.spark.{SparkConf, SparkContext}

object RDD_File_Load {
  def main(args: Array[String]): Unit = {
    val Conf = new SparkConf().setMaster("local").setAppName("fileLoad")
    val sc = new SparkContext(Conf)

    val rdd = sc.textFile("output1")
    println(rdd.collect().mkString(","))

    val rdd1 = sc.objectFile[(String, Int)]("output2")
    println(rdd1.collect().mkString(","))

    val rdd2 = sc.sequenceFile[String, Int]("output3")
    println(rdd2.collect().mkString(","))
    sc.stop()
  }
}
