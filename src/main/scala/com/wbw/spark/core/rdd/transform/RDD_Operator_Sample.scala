package com.wbw.spark.core.rdd.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

//随机抽取数字
object RDD_Operator_Sample extends App {

  val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("randomlyDrawNumbers")
  val sc = new SparkContext(sparkConf)
  val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

  /**
   * 第一个参数表示：抽取后是否放回
   * 第二个参数表示：如果不放回，则表示每个数抽取的概率       伯努利
   *               如果返回，则表示每个数被抽取的可能次数   泊松算法
   * 第三个参数表示：随机数种子，一旦随机数种子确定，抽取的数也就确定了
   */
  println(rdd.sample(withReplacement = true, 0.4, 1).collect().mkString(","))
  // TODO 关闭环境
  sc.stop()

}
