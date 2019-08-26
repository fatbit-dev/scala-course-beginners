package lectures.part1_basics

import scala.annotation.tailrec

object c04_Recursion extends App {

    def factorialDangerous(n: Int): Int = {
        if (n <= 1) {
            println(s"Computed factorial($n) --- result = 1")
            1
        }
        else {
            println(s"Computing factorial($n), I need factorial(${n - 1}) first...")
            val result = n * factorialDangerous(n - 1)
            println(s"Computed factorial($n) --- result = $result")
            result
        }
    }

    val d = 10
    println(s"factorialDangerous($d) = ${factorialDangerous(d)}") // Runs just fine!

    // Try this :)
    // println(factorialDangerous(50000)) // StackOverflowError!!

    // This new implementation is TAIL RECURSIVE.
    def factorialTailRecursive(n: Int): Int = {
        @tailrec
        def f(m: Int, acc: Int): Int = {
            if (m <= 1) {
                acc
            }
            else {
                f(m - 1, m * acc) // Tail Recursive: using recursive call as the LAST expression
            }
        }

        f(n, 1)
    }

    // This works, but the result is 0 because it's sooo big.
    val t = 50000
    println(s"factorialTailRecursive(n) = ${factorialTailRecursive(t)}")

    // This version allows big numbers ;)
    def factorial(n: Int): BigInt = {
        @tailrec
        def f(m: Int, acc: BigInt): BigInt = {
            if (m <= 1) {
                acc
            }
            else {
                f(m - 1, m * acc) // Tail Recursive: using recursive call as the LAST expression
            }
        }

        f(n, 1)
    }

    // And now this works, and prints a biiiiiig Int
    val n = 50000
    println(s"factorial(n) = ${factorial(n)}")

    //
    // When you need loops, USE TAIL RECURSION!
    //



}
