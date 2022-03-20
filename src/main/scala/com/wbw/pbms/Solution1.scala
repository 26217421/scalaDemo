package com.wbw.pbms

import scala.annotation.tailrec

object Solution1 {
  //P01 Find the last element of a list
  def last[T](list: List[T]) : T = list.last

  @tailrec
  def lastRecursion[T](list: List[T]): T = list match {
    case x :: Nil => x
    case _ :: xs => lastRecursion(xs)
    case _ => throw new NoSuchElementException("list is empty")
  }

  //P02  Find the last but one element of a list
  def secondLast[T](list: List[T]): T = if(list.isEmpty)
    throw new NoSuchElementException("list is empty") else
    list.init.last

  //P03 Find the Kth element of a list
  def nth[T](k: Int, list: List[T]): T = list(k)

  //P04  Find the number of elements of a list.
  def length[T](list: List[T]) = list.length

  //P05  Reverse a list.
  def reverse[T](list: List[T]) = list.reverse

  //P06  Find out whether a list is a palindrome.
  def isPalindrome[T](list: List[T]): Boolean = list == list.reverse

  //P07  Flatten a nested list structure.
  def flatten(list: List[Any]): List[Any] = {
    var result = List[Any]()
    for(el <- list) {
      el match {
        case xs : List[Any] =>
          result = result ++:flatten(xs)
        case _ =>
          result = result :+ el
      }
    }
    result
  }

  //P08  Eliminate consecutive duplicates of list elements.
  def compress[T >: Null <: Any](list: List[T]): List[T] = {
    def rec(input: List[T], result: List[T], last: T): List[T] = {
      input match {
        case x::xs if last != x => rec(xs,result :+ x, x)
        case x::xs => rec(xs, result, x)
        case Nil => result
      }
    }
    rec(list, List(), null)
  }

  //P09  Pack consecutive duplicates of list elements into sublists.

  def pack[T](list: List[T]): List[List[T]] = {
    list match {
      case x :: xs => (x +: xs.takeWhile(el => el == x)) +: pack(xs.dropWhile(el => el== x))
      case Nil => Nil
    }
  }

  //P10  Run-length encoding of a list.
  def encode[T](list: List[T]): List[(Int, T)] = pack(list).map(x => (x.size, x.head))

  def main(args: Array[String]): Unit = {
    //test
    //P01
    val last = Solution1.lastRecursion(List("a", "b", "c", "d"))
    println(last)
    //P02
    val numbers = List(1, 2, 11, 4, 5, 8, 10, 6)
    println(secondLast(numbers))
    //P03
    println(nth(2, List(1, 1, 2, 3, 5, 8)))
    //P04
    println(length(List(1, 1, 2, 3, 5, 8)))
    //P05
    println(reverse(List(1, 1, 2, 3, 5, 8)))
    //P06
    println(isPalindrome(List(1, 2, 3, 2, 1)))
    //P07
    println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
    //P08
    println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    //P09
    println(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    //P10
    println(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
}
