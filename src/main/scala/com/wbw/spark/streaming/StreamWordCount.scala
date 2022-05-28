package com.wbw.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamWordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("StreamWordCount")
    val ssc = new StreamingContext(conf, Seconds(3))

    val lineStreams = ssc.socketTextStream("remotehost", 8088)
    val wordStreams = lineStreams.flatMap(_.split(" "))
    val wordAndOneStreams = wordStreams.map((_, 1))
    val wordAndCountStreams = wordAndOneStreams.reduceByKey(_+_)
    wordAndCountStreams.print()

    ssc.start()
    ssc.awaitTermination()
    //ssc.stop()
  }

}
