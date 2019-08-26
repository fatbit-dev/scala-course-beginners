package exercises.part1_basics

import scala.annotation.tailrec

object e04_Recursion_Exersices extends App {

    // Exercise 1: Concatenate string n times.
    def concat(str: String, n: Int): String = {
        @tailrec
        def c(s: String, m: Int, acc: String): String = {
            if (m <= 1) {
                acc
            }
            else {
                c(s, m - 1, s + acc)
            }
        }

        c(str, n, str)
    }

    val n = 7
    val s = "hey!"
    val res = concat(s, n)
    println(s"concat('$s', $n) = $res")

    // Exercise 2: tail recursive version of isPrime(n).
    def isPrime(n: Int): Boolean = {
        @tailrec
        def innerPrime(m: Int, acc: Boolean): Boolean = {
            if (!acc)
                false
            else if (m <= 1)
                true
            else
                innerPrime(m - 1, acc && (n % m != 0))
        }

        innerPrime(n / 2, true)
    }

    val numPrime = 37
    println(s"isPrime($numPrime) == ${isPrime(numPrime)}")

    // Exercise 3: tail recursive fibonacci(n).
    def fibonacci(n: Int): Int = {

        // f(m, f(m-1), f(m-2))
        @tailrec
        def f(m: Int, m1: Int, m2: Int): Int = {
            if (m >= n)
                m1
            else
                f(m + 1, m1 + m2, m1)

        }

        if (n <= 2) {
            1
        }
        else {
            f(2, 1, 1)
        }
    }

    val numFib = 8
    println(s"fibonacci($numFib) = ${fibonacci(numFib)}") // 1 1 2 3 5 8 13 21
}
