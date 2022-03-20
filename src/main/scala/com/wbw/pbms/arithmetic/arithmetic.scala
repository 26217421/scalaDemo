package com.wbw.pbms {

  import scala.language.implicitConversions
  package arithmetic {

    import org.apache.commons.lang3.time.StopWatch

    import java.util.concurrent.TimeUnit
    import scala.annotation.tailrec

    class arithmetic(val start: Int) {

      import arithmetic._
      //P31  Determine whether a given integer number is prime
      def isPrime: Boolean =
        (start > 1) && (primes.takeWhile(_ <= Math.sqrt(start)).forall(start % _ != 0))

      //P33  Determine whether two positive integer numbers are coprime.
      def isCoprimeTo(x: Int): Boolean = gcd(start,x) == 1

      //P34  Calculate Euler’s totient function phi(m).
      def totientP34(): Int = (1 to start).count(start.isCoprimeTo(_))

      //P35  Determine the prime factors of a given positive integer.
      def primeFactors(): List[Int] = {
        def primeFactorsR(x: Int, ps: Stream[Int]): List[Int] = {
          x match {
            case n if n.isPrime => List(n)
            case n if(n % ps.head == 0) => ps.head :: primeFactorsR(n / ps.head, ps)
            case n => primeFactorsR(n, ps.tail)
          }
        }
        primeFactorsR(start, primes)
      }

      //P36  Determine the prime factors of a given positive integer (2).
      def primeFactorMultiplicity: Map[Int, Int] = {
        def factorCount(n: Int, p: Int): (Int, Int) =
          if (n % p != 0) (0, n)
          else factorCount(n / p, p) match { case (c, d) => (c + 1, d) }

        def factorsR(n: Int, ps: Stream[Int]): Map[Int, Int] =
          if (n == 1) Map()
          else if (n.isPrime) Map(n -> 1)
          else {
            val nps = ps.dropWhile(n % _ != 0)
            val (count, dividend) = factorCount(n, nps.head)
            Map(nps.head -> count) ++ factorsR(dividend, nps.tail)
          }
        factorsR(start, primes)
      }

      //P37  Calculate Euler’s totient function phi(m) (improved).
      def totient(): Int = start.primeFactorMultiplicity.foldLeft(1) { (r, f) =>
        f match { case (p, m) => r * (p - 1) * Math.pow(p, m - 1).toInt }
      }

      //P40  Goldbach’s conjecture.
      def goldbach: (Int,Int) =
        primes takeWhile { _ < start } find { p => (start - p).isPrime } match {
          case None     => throw new IllegalArgumentException
          case Some(p1) => (p1, start - p1)
        }


    }

    object arithmetic {
      implicit def int2S99Int(i: Int): arithmetic = new arithmetic(i)

      val primes: Stream.Cons[Int] = Stream.cons(2, Stream.from(3, 2) filter {
        _.isPrime
      })
      //P32  Determine the greatest common divisor of two positive integer numbers.
      @tailrec
      def gcd(i: Int, i1: Int): Int = if(i1 == 0) i else gcd(i1, i%i1)

      def consuming(): Unit = {
        val watch: StopWatch = new StopWatch
        watch.start()
        println(10090.totient())
        watch.stop()
        println(watch.getNanoTime)
        watch.reset()
        watch.start()
        println(10090.totientP34())
        watch.stop()
        println(watch.getNanoTime)
      }

      //P39  A list of prime numbers.
      def listPrimesinRange(r: Range): List[Int] =
        primes dropWhile { _ < r.start } takeWhile { _ <= r.last } toList

      //P41  A list of Goldbach compositions.
      def printGoldbachList(r: Range): Unit = {
        printGoldbachListLimited(r, 0)
      }

      def printGoldbachListLimited(r: Range, limit: Int): Unit = {
        (r filter { n => n > 2 && n % 2 == 0 } map { n => (n, n.goldbach) }
          filter { _._2._1 >= limit } foreach { case (n, (p1, p2)) => println(n + " = " + p1 + " + " + p2) })
      }

      def main(args: Array[String]): Unit = {
        //P31
        println(7.isPrime)
        //P32
        println(gcd(36, 63))
        //P33
        println(35.isCoprimeTo(64))
        //P34
        println(10.totientP34())
        //P35
        println(315.primeFactors())
        //P36
        println(315.primeFactorMultiplicity)
        //P37
        println(10.totient())
        //P38
        consuming()
        //P39
        println(listPrimesinRange(7 to 31))
        //P40
        println(28.goldbach)
        //P41
        println( printGoldbachList(9 to 20))
      }
    }
  }

}
