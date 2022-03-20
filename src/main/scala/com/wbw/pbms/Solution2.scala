package com.wbw.pbms

import scala.annotation.tailrec

object Solution2 {
  //P11  Modified run-length encoding.
  def encodeModified[T](list: List[T]): List[Any] = {
    Solution1.pack(list).map {
      case x :: Nil => x
      case l@x :: _ => (l.length, x)
      case Nil => Nil
    }
  }
  //P12  Decode a run-length encoded list.
  def decode[T](list: List[Any]): List[T] = {
    @tailrec
    def decodeR(encoded: List[Any], result: List[T]): List[T] = encoded match {
      case ((n: Int, e: T) :: xs) => decodeR(xs, result ++ List.fill(n)(e))
      case ((e: T) :: xs) => decodeR(xs, result :+ e)
      case Nil => result
    }
    decodeR(list, List())
  }
  //P13  Run-length encoding of a list (direct solution).
  def encodeDirect[T](list: List[T]): List[Any] = list match {
    case x :: xs =>
      val (consecutiveDuplicates, remaining) = xs.span(_ == x)
      (consecutiveDuplicates.length + 1, x) +: encodeDirect(remaining)
    case Nil => Nil
  }
  //P14  Duplicate the elements of a list.
  def duplicate[T](list: List[T]): List[T] = list.flatMap(x => List(x,x))

  //P15  Duplicate the elements of a list a given number of times.
  def duplicateN[T](i: Int, list: List[T]): List[T] = list.flatMap(x => List.fill(i)(x))

  //P16  Drop every Nth element from a list.
  def drop[T](n: Int, list: List[T]): List[T] = {
    if(n == 0) {
      list
    } else {
      list.zipWithIndex.withFilter(t => (t._2+1)%n !=0).map(_._1)
    }
  }

  //P17  Split a list into two parts.
  def split[T](i: Int, list: List[T]): (List[T], List[T]) = list.splitAt(i)

  //P18  Extract a slice from a list.
  def slice[T](i: Int, i1: Int, list: List[T]): Any = list.slice(i,i1)

  //P19  Rotate a list N places to the left.
  def rotate[T](i: Int, list: List[T]): Any = {
    val (a,b) = list.splitAt(makeNPositive(list, i))
    b ++: a
  }

  //P20  Remove the Kth element from a list.
  def removeAt[T](i: Int, list: List[T]): (List[T], T) = (list.take(i) ++ list.drop(i+1), list(i))

  def main(args: Array[String]): Unit = {
    //P11
    println(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    //P12
    println(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
    //P13
    println(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    //P14
    println(duplicate(List('a, 'b, 'c, 'c, 'd)))
    //P15
    println(duplicateN(3, List('a, 'b, 'c, 'c, 'd)))
    //P16
    println(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    //P17
    println(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    //P18
    println(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    //P19
    println(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    //P20
    println(removeAt(1, List('a, 'b, 'c, 'd)))
  }

  private def makeNPositive[T](list: List[T], n: Int): Int = if (n < 0) list.length + n else n
}
