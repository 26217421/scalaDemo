package com.wbw.spark.core.rdd.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RDD_Operator_SortBy extends App {
  val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sort")
  val sc = new SparkContext(sparkConf)
  val rdd = sc.makeRDD(List(6,2,4,5,3,1), 2)
  // sortBy方法可以根据指定的规则对数据源中的数据进行排序，默认为升序，第二个参数可以改变排序的方式
  // sortBy默认情况下，不会改变分区。但是中间存在shuffle操作
  val newRDD: RDD[Int] = rdd.sortBy(num=>num)

  newRDD.saveAsTextFile("output")


  sc.stop()

}
