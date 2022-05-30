package com.wbw.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object FileStream {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("FileStream")
    val ssc = new StreamingContext(conf, Seconds(4))
    val lineStraeam = ssc.receiverStream(new CustomReceiver("remotehost", 8088))
    val wordStream = lineStraeam.flatMap(_.split("\t"))
    val wordAndOneStream = wordStream.map((_, 1))
    val wordAndCountStream = wordAndOneStream.reduceByKey(_+_)
    wordAndCountStream.print()
    ssc.start()
    ssc.awaitTermination()
  }

}
