package lectures.part1_basics

object c02_Expressions extends App {

    // Numerical Operators:
    // +, -, *, /
    // & ---> Bitwise AND
    // | ---> Bitwise OR
    // ^ ---> Bitwise XOR
    // <<, >> ---> Left, Right shift
    // <<<, >>> ---> Left, Right shift with zero extension

    val result = 5 + 2 // Expression, Scala will infer the type
    println(result)
    println(2 + 3 * 5) // Another expression

    // Logical Operators:
    // ==, !=, >, <, >=, <=
    // !, &&, ||

    println(result == 7)
    println(result != 7)


    // Numerical Operators and Assignments:
    // +=, -=, *=, /= ---> Only work with variables, so they have side-effects.
    var aVar = 5
    aVar += 2 // equals to 7

    // Instructions (DO) vs. Expressions (VALUE).

    // IF expression (it's not IF instruction, as in other languages):
    val aCondition = true
    val aConditinedValue = if(aCondition) 5 else 2
    println(aConditinedValue)
    // The next IF evaluates to a value:
    println(if(aCondition) 5 else 2) // Prints 5

    // Here is the WHILE loop, but NEVER USE IT IN Scala!!
    var i = 0;
    while (i < 10) {
        println(i)
        i = i + 1
    }

    // Everything in Scala is an Expression!

    val aWeirdVariable = (aVar = 7) // The inferred type of aWeirdVariable is Unit
    println(aWeirdVariable) // This prints "()", this is Unit (=== void)

    // CodeBlocks
    val aCodeBlock = {
        val x = 2
        val y = x + 1

        if (x > 2) "hello" else "goodbye"
    }


}
