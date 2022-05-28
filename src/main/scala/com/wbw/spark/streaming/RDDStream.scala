package com.wbw.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

object RDDStream {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("")
    val ssc = new StreamingContext(conf, Seconds(4))

    val rddQueue = new mutable.Queue[RDD[Int]]()

    val inputStream = ssc.queueStream(rddQueue, oneAtATime = false)

    val mappedStream = inputStream.map((_,1))
    val reducedStream = mappedStream.reduceByKey(_+_)
    reducedStream.print()
    ssc.start()
    for (i <- 1 to 5) {
      rddQueue += ssc.sparkContext.makeRDD(1 to 300, 10)
      Thread.sleep(2000)
    }
    ssc.awaitTerminationOrTimeout(4000)
  }

}
