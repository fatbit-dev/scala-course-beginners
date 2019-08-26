package lectures.part2_OOP

object c01_OOBasics extends App {

    val person = new Person("John", 27)
    println(person.age)

    var dog = new Dog("Panther", 12)
    println(dog.x)
    dog.greet("Juan")
}

// class Person(name: String, age: Int) // Constructor
// Beware! class parameters are not fields!

class Person(name: String, val age: Int) // Constructor
// With val, I can make fields from class parameters

class Dog(name: String, val age: Int) {
    val x = 2

    println(1 + 3)

    def greet(name: String): Unit = println(s"${this.name} says: Woof, woof, $name")

    // Overloading methods.
    def greet(): Unit = println(s"Hi, a am $name")

    // Overloading constructor
    def this(name: String) = this(name, 0)
    def this() = this("John Doe")
}
