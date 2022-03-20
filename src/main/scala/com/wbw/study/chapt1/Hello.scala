package com.wbw.study.chapt1

/*
   object: 关键字，声明一个单例对象（伴生对象）
 */
object Hello {
  /*
    main 方法：从外部可以直接调用执行的方法
    def 方法名称(参数名称: 参数类型): 返回值类型 = { 方法体 }
   */
  def main(args: Array[String]): Unit = {
    println("hello scala")
    System.out.println("hello scala")
  }
}
