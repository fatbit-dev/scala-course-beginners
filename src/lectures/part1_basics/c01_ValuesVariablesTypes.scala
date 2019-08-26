package lectures.part1_basics

object c01_ValuesVariablesTypes extends App {

    //** Values
    val x: Int = 42
    println(x)

    // x = 43 =====> Error! val means immutable (like const or final in C or java)

    val aString: String = "hey!"
    val aBoolean: Boolean = true
    val aChar: Char = 'f'
    val anInr: Int = 42
    val aShort: Short = 4032 // 2 bytes
    val aLong: Long = 2345234522345L
    val aFloat: Float = 2.0f
    val aDouble: Double = 3.14

    //** Variables
    var aVar: Int = 42
    aVar = 5 // Now we can reassign, but it has side-effects! Try not to use var :)


}
