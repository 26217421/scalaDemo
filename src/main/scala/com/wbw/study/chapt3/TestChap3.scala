package com.wbw.study.chapt3

import scala.beans.BeanProperty

/**
 * scala没有public 一个.scala文件可以有多个类
 * 访问权限
 * scala属性方法访问权限默认为public，但scala没有public关键字
 * private为私有权限，只在类的内部和伴生对象中可用
 * protected为受保护权限，同类子类可以访问，同包不行
 * private[包名]增加包访问权限，名下的其他类也可以使用
 * 继承
 * scala中属性与方法都是动态绑定，java只有方法是动态绑定
 *抽象类 abstract
 * 1）如果父类为抽象，那么子需要将的属性和方法实现 否则也声明为抽象类
 * 2）重写非抽象方法需要用 override修饰，重写抽象方法则可以不加 override 修饰。
 * 3）子类中调用父类的方法使用super关键字
 * 4）子类对抽象属性进行实现，父可以用 子类对抽象属性进行实现，父可以用 var 修饰
 * 子类对非抽象属性重写 ，父类非抽象属性只支持val类型，而不支持var类型。
 */

class Teacher extends Person {
  //变量名不能覆盖可变变量
  override val name = "teacher"
  override def hello(): Unit = {
    println("hello teacher")
  }
}
class Person {
  val name:String = "wbw"
  var age:Int = _ //_表示给属性一个默认值
  //val修饰的属性不能赋默认值 必须显式
  //bean属性 自动生成setter getter
  @BeanProperty var sex = "男"
  def hello():Unit =  {
    println("hello wbw")
  }
}

/**
 * 单例对象（与类名相同的为伴生对象）
 * 模拟类对象，是为了与Java交互（因为scala没有静态的概念
 */
object Person {
  var country = "China"
  def apply(): Person = {
    println("apply空参被调用")
    new Person()
  }
  def main(args: Array[String]): Unit = {
    var person:Person = new Person()
    var teacher:Teacher = new Teacher
    var person1:Person = new Teacher
    println(person.name)
    println(person.age)
    person.setSex("女")
    println(person.getSex)

    println(teacher.name)
    teacher.hello()
    println(person1.name)
    person1.hello()

  }
}
object Test1 {
  def main(args: Array[String]): Unit = {
    //伴生对象的属性方法可以通过类名访问
    println(Person.country)
    //实际调用apply方法，apply方法可以重载
    val p1 = Person()
  }
}
