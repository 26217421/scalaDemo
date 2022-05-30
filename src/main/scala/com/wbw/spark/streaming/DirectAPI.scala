package com.wbw.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object DirectAPI {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("DirectAPI")
    val ssc = new StreamingContext(conf, Seconds(3))


  }
}
