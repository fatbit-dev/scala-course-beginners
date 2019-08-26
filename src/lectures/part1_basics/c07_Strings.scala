package lectures.part1_basics

object c07_Strings extends App {

    val str: String = "Hello to all the Scala people!"

    println(str)
    println(str.charAt(4))
    println(str.substring(7, 11)) // [7..11)
    println(str.split(" ").toList)
    println(str.startsWith("Hello"))
    println(str.replace(" ", "-"))
    println(str.toLowerCase())
    println(str.length)

    val aNumberString = "2"
    val aNumber = aNumberString.toInt

    println('a' +: aNumberString :+ 'z')

    println(str.reverse)
    println(str.take(2))

    // Scala-specific: String Interpolators

    // S-interpolators
    val name = "David"
    val age = 12
    val greeting = s"Hello, I'm $name and I am $age years old"
    val greeting2 = s"Hello, I'm $name and I'll be turning ${age + 1} years old"
    println(greeting)
    println(greeting2)

    // F-interpolators (printf like)
    val speed = 1.2f
    val myth = f"$name%s can eat $speed%2.2f burgers per minute"
    println(myth)

    // raw-interpolator (donesn't escape characters)
    println(raw"This is a \n newline")
    val escaped = "This is a \n newline"
    println(raw"$escaped")
}
