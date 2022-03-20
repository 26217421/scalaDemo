package com.wbw.spark.rdd.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import java.text.SimpleDateFormat
import java.util.Date


object RDD_Operator_GroupBy extends App {
  val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("transform")
  val sc = new SparkContext(sparkConf)
  // 按照首字母进行分组
  val rdd: RDD[String] = sc.makeRDD(List("Hadoop","Spark","Scala","Hive"))
  val value: RDD[(Char, Iterable[String])] = rdd.groupBy(_.charAt(0))

  // 从服务器日志数据 apache.log 中获取每个时间段访问量
  val rdd1: RDD[String] = sc.textFile("input/apache.log")
  val timeRDD: RDD[(String, Iterable[(String, Int)])] = rdd1.map(
    line => {
      val time: String = line.split(" ")(3)
      val sdf = new SimpleDateFormat("dd/MM/yy:HH:mm:ss")
      val date: Date = sdf.parse(time)
      val sdf1 = new SimpleDateFormat("HH")
      val hour: String = sdf1.format(date)
      (hour, 1)
    }
  ).groupBy(_._1) // _._1 获取元组第一个元素  ._1：取第一个元素
  val value1: RDD[(String, Int)] = timeRDD.map {
    case (hour, iter) => (hour, iter.size)
  }
  value.collect().foreach(println)

  value1.collect().foreach(println)
  // TODO 关闭环境
  sc.stop()
}
