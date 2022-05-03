package com.wbw.spark.sql

import org.apache.spark.sql.SaveMode

import java.util.Properties

object mysqlExample {
  import day01.spark
  import spark.implicits._
  def main(args: Array[String]): Unit = {
    spark.read.format("jdbc")
      .option("url", "jdbc:mysql://remotehost:3306/spark_sql?useSSL=false")
      .option("driver", "com.mysql.cj.jdbc.Driver")
      .option("user", "root")
      .option("password", "123456")
      .option("dbtable", "user").load().show()
    val properties = new Properties()
    properties.setProperty("user", "root")
    properties.setProperty("password", "123456")
    properties.setProperty("driver", "com.mysql.cj.jdbc.Driver")
    val rdd = spark.sparkContext.makeRDD(List(User("龙五", 27), User("王四", 36)))
    val ds = rdd.toDS
    ds.write.mode(SaveMode.Append)
      .jdbc("jdbc:mysql://remotehost:3306/spark_sql?useSSL=false", "user", properties)
    ds.sparkSession.read
      .jdbc("jdbc:mysql://remotehost:3306/spark_sql?useSSL=false", "user", properties)
      .show()
    spark.stop()
  }

  case class User(name:String, age:Long)
}
