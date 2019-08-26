package exercises.part1_basics

object e03_Functions_Exercises extends App {

    // Exercise 1: Simple greeting function.
    def greeting(name: String, age: Int): Unit = {
        println(s"Hi, my name is $name and I am $age years old.")
    }

    greeting("Juan", 40)

    // Exercise 2: Factorial function (1 * 2 * 3 * ... * n).
    def factorial(n: Int): Int = {
        def f(m: Int): Int = {
            if (m == 1)
                1
            else
                m * f(m - 1)
        }

        f(n)
    }

    val num = 5
    println(s"factorial($num) = ${factorial(num)}")

    // Exercise 3: Fibonacci function.
    // f(1) = 1
    // f(2) = 1
    // f(n) = f(n - 1) + f(n - 2)
    def fibonacci(n: Int): Int = {
        def f(m: Int): Int = {
            if (m <= 2)
                1
            else
                f(m - 1) + f(m - 2)
        }

        f(n)
    }

    val numFib = 8
    println(s"fibonacci($numFib) = ${fibonacci(numFib)}")

    // Exercise 4: Test if a number is prime.
    def isPrime(n: Int): Boolean = {
        def innerPrime(m: Int): Boolean = {
            if (m <= 1)
                true
            else
                n % m != 0 && innerPrime(m - 1)
        }

        innerPrime(n / 2)
    }

    val numPrime = 37
    println(s"isPrime($numPrime) == ${isPrime(numPrime)}")
}
