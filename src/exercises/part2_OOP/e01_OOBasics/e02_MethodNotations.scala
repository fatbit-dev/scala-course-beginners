package exercises.part2_OOP.e01_OOBasics

object e02_MethodNotations extends App {

    class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
        def likes(movie: String): Boolean = movie == favoriteMovie

        def hangoutWith(mate: Person): String = s"${this.name} is hanging out with ${mate.name}"
        def +(mate: Person): String = s"${this.name} is hangin' out with ${mate.name}"
        def unary_! : String = s"$name what the heck!"
        def isAlive: Boolean = true
        def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

        // Exercise methods
        def +(nickname: String) = new Person(s"$name ($nickname)", favoriteMovie)
        def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
        def learns(lang: String): String = s"$name learns $lang"
        def learnScala(): String = this learns "Functional Programming with Scala"
        def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
    }

    val mary = new Person("Mary", "The Goonies")

    // Exercise 1:
    println((mary + "the RockStar!")())
    val maryRock: Person = mary + "the Rockstar"
    println(maryRock.name)

    // Exercise 2:
    println(s"mary.age = ${mary.age}")
    println(s"+mary.age = ${(+mary).age}")

    // Exercise 3:
    println(mary.learns("Java"))
    println(mary learns "Scala")
    println(maryRock learnScala)

    // Exercise 4:
    println(mary.apply(2))
    println(maryRock(4))
}
