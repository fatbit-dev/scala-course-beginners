package exercises.part2_OOP.e01_OOBasics

// By declaring a parameter with 'val', we make the parameter a class field,
// and Scala provides us with prebuilt getters for 'count'.
class Counter(val count: Int = 0) {

    def inc(): Counter = {
        println("++ inc!")
        new Counter(count + 1)
    }

    def dec(): Counter = {
        println("-- dec!")
        new Counter(count - 1)
    }

    // This is the straight-forward way
    // def inc(amount: Int): Counter = new Counter(count + amount)
    // def dec(amount: Int): Counter = new Counter(count - amount)

    // This is the Scala, functional way: recursion!
    def inc(n: Int): Counter = {
        if (n <= 0) this
        else inc.inc(n - 1)
    }

    def dec(n: Int): Counter = {
        if (n <= 0) this
        else dec.dec(n - 1)
    }

    def print: Unit = println(s"count = $count")
}
