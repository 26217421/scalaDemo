package com.wbw.spark.rdd.serialization

import org.apache.spark.{SparkConf, SparkContext}

object Kryo {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("").set("spark.serializer",
      "org.apache.spark.serializer.KyroSerializer").registerKryoClasses(Array(classOf[User]))
    val sc: SparkContext = new SparkContext(conf)

    val rdd = sc.makeRDD(List[Int](1,2,3,4))

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
