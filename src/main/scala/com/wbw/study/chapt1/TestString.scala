package com.wbw.study.chapt1

object TestString {
  def main(args: Array[String]): Unit = {
    var name: String = "wbw"
    var age : Int = 18
    println(name + " " + age)
    printf("name=%s age=%d\n", name, age)
    //多行字符串 stripMargin方法
    val s=
      """
        |select
        |   name
        |   age
        |from user
        |where name = "zhangsan"
        """.stripMargin
        println(s)
    //scala字符串替换变量 字符串前加s 
    val s2 = s"name=$name"
    println(s2)
  }
}
