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
    spark.sql("CREATE DATABASE IF NOT EXISTS wbw")
    spark.sql("use wbw")
    spark.sql(
      """
        |CREATE TABLE `user_visit_action`(
        |  `date` string,
        |  `user_id` bigint,
        |  `session_id` string,
        |  `page_id` bigint,
        |  `action_time` string,
        |  `search_keyword` string,
        |  `click_category_id` bigint,
        |  `click_product_id` bigint,
        |  `order_category_ids` string,
        |  `order_product_ids` string,
        |  `pay_category_ids` string,
        |  `pay_product_ids` string,
        |  `city_id` bigint)
        |row format delimited fields terminated by '\t'
            """.stripMargin)
    spark.sql(
      """
        |load data local inpath 'input/user_visit_action.txt' into table wbw.user_visit_action
            """.stripMargin)

    spark.sql(
      """
        |CREATE TABLE `product_info`(
        |  `product_id` bigint,
        |  `product_name` string,
        |  `extend_info` string)
        |row format delimited fields terminated by '\t'
            """.stripMargin)
    spark.sql(
      """
        |load data local inpath 'input/product_info.txt' into table wbw.product_info
            """.stripMargin)

    spark.sql(
      """
        |CREATE TABLE `city_info`(
        |  `city_id` bigint,
        |  `city_name` string,
        |  `area` string)
        |row format delimited fields terminated by '\t'
            """.stripMargin)
    spark.sql(
      """
        |load data local inpath 'input/city_info.txt' into table wbw.city_info
            """.stripMargin)

    spark.sql("""select * from city_info""").show
    spark.close()
  }
}
