package lectures.part1_basics

object c05_CallingByName_and_ByValue extends App {

    def calledByValue(t: Long): Unit = {
        println(s"byValue: $t   -------- They are the same")
        println(s"byValue: $t  /")
    }

    // Useful in lazy streams
    def calledByName(t: => Long): Unit = {
        println(s"byName: $t   --------- They are different!")
        println(s"byName: $t  /")
    }

    calledByValue(System.nanoTime())
    calledByName(System.nanoTime())

    def infinite(): Int = 1 + infinite()
    def printFirst(x: Int, y: => Int) = println(x)

    // printFirst(infinite(), 34) // StackOverflowError!!
    printFirst(34, infinite()) // infinite() is never evaluated, because when calling by name
                               // the parameter (expression) is not executed until it's needed
}
