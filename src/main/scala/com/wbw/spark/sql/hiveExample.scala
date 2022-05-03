package com.wbw.spark.sql

import org.apache.spark.sql.SparkSession

import java.io.File

object hiveExample {
  def main(args: Array[String]): Unit = {
    val warehouseLocation = new File("spark-warehouse").getAbsolutePath
    val spark = SparkSession
      .builder()
      .config("spark.sql.warehouse.dir", warehouseLocation)
      .appName("app")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()
    import spark.implicits._
    spark.sql("drop table if exists src")
    spark.sql("CREATE TABLE IF NOT EXISTS src (key INT, value STRING) USING hive")
    spark.sql("select * from src").show()
    spark.stop()
  }
}
