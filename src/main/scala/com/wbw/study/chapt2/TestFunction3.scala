package com.wbw.study.chapt2

/**
 * 函数柯里化&闭包
 * 闭包：如果一个函数访问到外部变量的值，那么函数与所处环境成为闭包
 * 函数柯里化：把一个参数列表的多个参数变为多个参数列表
 * 例：Prac1_2
 * java只有值调用，没有名调用
 *
 * 惰性加载
 * 当函数返回值被声明lazy时。函数执行推迟，直到首次取值，函数才会执行，这种函数成为惰性函数
 *
 */
object TestFunction3 {
  def main(args: Array[String]): Unit = {
    def f1()= {
      var a:Int = 10
      def f2(b:Int)={
        a + b
      }
      f2 _
    }
    val f = f1()
    //变量a没有释放 包含在f2内部 形成闭合的效果
    println(f(3))
    println(f1()(3))
    //函数柯里化一定存在闭包
    //递归
    println(test(5))
    //控制抽象
    def ff = ()=> {
      println("ff...")
      10
    }
    foo(ff())
    foo1(ff())

    lazy val res = sum(1,2)
    println("-------")
    println("res = " + res)
  }
  //scala中的递归必须声明函数返回值类型
  def test(i: Int): Int = {
    if(i == 1) 1 else i * test(i - 1)
  }
  //值调用
  def foo(a: Int):Unit ={
    println(a)
    println(a)
  }
  //名调用（传递代码）
  def foo1(a: => Int):Unit ={
    println(a)
    println(a)
  }

  def sum(n1: Int, n2: Int): Int = {
    println("sum执行。。。")
    return n1 + n2
  }
}
