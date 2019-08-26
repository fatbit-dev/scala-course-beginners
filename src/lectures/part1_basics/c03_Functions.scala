package lectures.part1_basics

object c03_Functions extends App {

    def aFunction(a: String, b: Int): String = {
        a + " " + b
    }

    println(aFunction("hello", 3))

    def aParameterlessFunction(): Int = 42

    println(aParameterlessFunction())
    println(aParameterlessFunction)

    // If you need loops, use recursion!
    def aRecursiveFunction(str: String, n: Int): String = {
        if (n == 1)
            str
        else
            str + aRecursiveFunction(str, n-1)
    }

    println(aRecursiveFunction("hello", 3))

    def aFunctionWithSideEffects(str: String): Unit = println(str)

    def aBigFunction(n: Int): Int = {
        def aSmallerFunction(a: Int, b: Int): Int = a + b

        aSmallerFunction(n, n-1)
    }


}
