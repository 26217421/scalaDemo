package com.wbw.spark.core.rdd.serialization

import org.apache.spark.{SparkConf, SparkContext}

object Serializable01 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("")
    val sc: SparkContext = new SparkContext(conf)
    val rdd = sc.makeRDD(List[Int]())

    val user = new User()

    // SparkException: Task not serializable
    // NotSerializableException: com.atguigu.bigdata.spark.core.rdd.operator.action.Spark07_RDD_Operator_Action$User

    // RDD算子中传递的函数是会包含闭包操作，那么就会进行检测功能
    // 闭包检测
    rdd.foreach(
      num => {
        println("age = " + (user.age + num))
      }
    )

    sc.stop()
  }

  class User extends Serializable {
    var age : Int = 30
  }
}
