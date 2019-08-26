package lectures.part2_OOP

object c02_MethodNotations extends App {

    class Person(val name: String, favoriteMovie: String) {
        def likes(movie: String): Boolean = movie == favoriteMovie

        def hangoutWith(mate: Person): String = s"${this.name} is hanging out with ${mate.name}"
        def +(mate: Person): String = s"${this.name} is hangin' out with ${mate.name}"
        def unary_! : String = s"$name what the heck!"
        def isAlive: Boolean = true
        def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    }

    val mary = new Person("Mary", "The Goonies")

    // Syntantic Sugar! -- Infix notation, or Operator notation.
    // Works with functions that only take one argument:
    println(mary.likes("The Goonies"))
    println(mary likes "The Goonies")

    // Operators in Scala
    val tom = new Person("Tommy", "Casablanca")

    println(mary hangoutWith tom)
    println(mary + tom)
    println(mary.+(tom))

    // Previously known operators work just the same: all operators are methods.
    println(1 + 2)
    println(1.+(2))

    // Prefix notation in Scala (it's about unary operators).
    val x = -1
    val y = 1.unary_-
    // unary_ prefix only works with +, -, ~, ! symbols.

    println(!mary)
    println(mary.unary_!)

    // Postfix notation in Scala (only for methods without parameters).
    println(mary.isAlive)
    println(mary isAlive)

    // apply()
    println(mary.apply())
    println(mary()) // equivalent to mary.apply()
}
