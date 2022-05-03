package com.wbw.spark.sql

import org.apache.spark.sql.SparkSession

object day01 {
  val spark: SparkSession = SparkSession
    .builder()
    .appName("app")
    .master("local[*]")
    .getOrCreate()
  def main(args: Array[String]): Unit = {

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
    idRDD.collect.foreach(println)
    idRDD.toDF("id").show
    val df1 = sc.makeRDD(List(("ZhangSan", 30), ("LiSi", 40))).map(t =>User(t._1, t._2)).toDF()
    df1.show
    val rdd = df1.rdd
    val array = rdd.collect
    println(array(0))
    println(array(0)(0))
    println(array(0).getAs[String]("name"))
    val caseDS = Seq(Person("zhangsan", 22)).toDS()
    caseDS.show()
    val ds = Seq(1,2,3,4,5).toDS()
    ds.show()
    val res1 = sc.makeRDD(List(("ZhangSan", 30), ("LiSi", 40))).map(t =>User(t._1, t._2)).toDS()
    res1.rdd.collect.foreach(print)
    //dataframe dataSet 互相转换
    val frame = sc.makeRDD(List(("ZhangSan", 30), ("LiSi", 40))).toDF("name", "age")
    val ds1 =  frame.as[User]
    ds1.toDF()
    //自定义函数
    spark.udf.register("addName", (x:String)=>"Name:"+x)
    df.createOrReplaceTempView("people")
    spark.sql("select addName(username) as Name, age from people").show()

    spark.stop()
  }

  case class User(name: String, age:Int)
  case class Person(name: String, age: Long)
}
