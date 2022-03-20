package com.wbw.study.chapt2

object Prac1 {
  def main(args: Array[String]): Unit = {
    var fun = (a: Int,s: String,c: Char)=> {
      if(a == 0 && s.equals("") && c == '0') {
        true
      } else {
        false
      }
    }
    println(fun(0,"",'0'))

    def func(a:Int):String =>(Char=>Boolean) = {
      def f1(s:String):Char=>Boolean = {
        def f2(c:Char): Boolean = {
          if(a == 0 && s== "" &&c == 0) {
            false
          } else
            true
        }
        f2
      }
      f1
    }
    println(func(0)("")('0'))
    //匿名函数简写
    def func1(a:Int):String =>(Char=>Boolean) = {
      s => c=> if(a==0&&s==""&&c=='0') false else true
    }
    println(func1(0)("")('0'))


  }

}
