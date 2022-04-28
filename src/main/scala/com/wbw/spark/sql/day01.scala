package com.wbw.spark.sql

import org.apache.spark.sql.SparkSession

object day01 {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("app")
      .master("local[*]")
      .getOrCreate()
    val sc  = spark.sparkContext
    import spark.implicits._
    val df = spark.read.json("./input/user.json")
    println(df)
    df.printSchema()
    df.createOrReplaceTempView("people")
    val sqlDF = spark.sql("select * from people")
    println(sqlDF)
    sqlDF.show()

    df.select($"username", $"age" + 1 as "newage").show()
    df.select('username ,'age + 1).show
    df.filter('age > 30).show()
    df.groupBy("age").count().show()

    //RDD转DataFrame
    val idRDD = sc.textFile("input/id.txt")
    idRDD.foreach(println)
    idRDD.toDF("id").show
    sc.makeRDD(List(("ZhangSan", 30), ("LiSi", 40))).map(t =>User(t._1, t._2)).toDF().show

    spark.stop()
  }

  case class User(name: String, age:Int)
}
