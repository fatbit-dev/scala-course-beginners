package lectures.part2_OOP

object c03_Objects extends App {

    // Scala DOES NOT HAVE Class-Level functionality ("static"), it uses Objects.
    // Objects are similar to Classes, but they cannot receive parameters.
    object Person {
        // "static"/class-level functionality.
        val N_EYES = 2
        def canFly: Boolean = false

        // Factory Method here:
        def from(mother: Person, father: Person): Person = new Person("Bobbie")
        // It's common to use apply() as a factory method:
        def apply(mother: Person, father: Person): Person = new Person("Bobbie")
    }

    class Person(val name: String) {
        // instance-level functionality.
    }

    // When we declare an object with the same name of a class, we call this a
    // COMPANION OBJECT.

    println(Person.N_EYES)
    println(Person.canFly)

    // A Scala Object is a Singleton instance.
    val mary = Person
    val john = Person
    println(mary == john)

    val jim = new Person("Jim")
    val joe = new Person("Joe")
    println(jim == joe)

    val bobbie = Person.from(jim, joe)

    val bobbieApply = Person.apply(jim, joe)
    val bobbieApply2 = Person(jim, joe)

    // Scala Application == An Scala object with this method:
    // def main(args: Array[String]): Unit
    //
    // Using this, we don't need the 'extends App' on our main object definition
}
