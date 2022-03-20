package com.wbw.pbms

object Solution3 {
  //P21  Insert an element at a given position into a list.
  def insertAt[T](e: T, n: Int, list: List[T]): List[T] = list.take(n) ::: e :: list.drop(n)

  //P22  Create a list containing all integers within a given range.
  def range(i: Int, i1: Int): List[Int] = {
    if(i <= i1)
      i :: range(i+1,i1)
    else
      Nil
  }

  //P23  Extract a given number of randomly selected elements from a list.
  def randomSelect[T](n: Int, ls: List[T]): List[T] = {
    if (n <= 0) Nil
    else {
      val (rest, e) = Solution2.removeAt((new util.Random).nextInt(ls.length), ls)
      e :: randomSelect(n - 1, rest)
    }
  }

  //P24  Lotto: Draw N different random numbers from the set 1..M.
  def lotto(count: Int, max: Int): List[Int] = {
    randomSelect(count, List.range(1, max + 1))
  }

  //P25  Generate a random permutation of the elements of a list.
  def randomPermute[T](list: List[T]): Any = {
    randomSelect(list.length, list)
  }

  //P26 Generate the combinations of K distinct objects chosen from the N elements of a list.
  def flatMapSublists[A,B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
    ls match {
      case Nil => Nil
      case sublist@(_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
    }

  def combinations[A](n: Int, ls: List[A]): List[List[A]] =
    if (n == 0) List(Nil)
    else flatMapSublists(ls) { sl =>
      combinations(n - 1, sl.tail).map({sl.head :: _})
    }

  //P27  Group the elements of a set into disjoint subsets.
  /*
    In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons?
    Write a function that generates all the possibilities.
  */
  def group3[T](list: List[T]): List[List[List[T]]] = {
    for{
      a <- combinations(2, list)
      noA = list.diff(a);
      b <- combinations(3, noA)
    } yield List(a, b, noA diff  b)
  }
  /*
    b) Generalize the above predicate in a way that we can specify a list of group sizes
    and the predicate will return a list of groups.
  */
  def group[T](ints: List[Int], list: List[T]): List[List[List[T]]] = ints match {
    case Nil     => List(Nil)
    case n :: ns => combinations(n, list) flatMap { c =>
      group(ns, list diff c) map {c :: _}
    }
  }

  //P28  Sorting a list of lists according to length of sublists.
  def lsort[T](list: List[List[T]]): List[List[T]] = {
    list.sortBy(_.length)
  }
/*
  b) Again, we suppose that a list contains elements that are lists themselves.
  But this time the objective is to sort the elements according to their length frequency;
  i.e. in the default, sorting is done ascendingly, lists with rare lengths are placed,
  others with a more frequent length come later.
*/
def lfsort[T](list: List[List[T]]): List[List[T]] =
  lsort(list)
    .groupBy(_.length).values.toList
    .sortBy(_.length)
    .flatten

  def main(args: Array[String]): Unit = {
    //P21
    println(insertAt('new, 1, List('a, 'b, 'c, 'd)))
    //P22
    println(range(4, 9))
    println(List.range(4,10))
    //P23
    println(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    //P24
    println(lotto(6, 49))
    //P25
    println(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)))
    //P26
    println(combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)))
    //P27
    println(group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")))
    println(group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")))
    //P28
    println(lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
    println(lfsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
  }



}
