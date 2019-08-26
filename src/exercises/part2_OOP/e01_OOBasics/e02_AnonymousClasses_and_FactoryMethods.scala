package exercises.part2_OOP.e01_OOBasics

object e02_AnonymousClasses_and_FactoryMethods extends App {

    class Person(val name: String, val age: Int) {
        def greet: Unit = println(s"Hello, my name is $name. I am pleased to meet you.")
    }

    object Person {
        def newborn(name: String, mama: Person, papa: Person): Person = new Person(name, 0) {
            val mother: Person = mama
            val father: Person = papa
            override def greet: Unit = println(s"Hi. I'm ${mother.name}'s & ${father.name}'s child $name") // Lacks manners!
        }
    }

    val mary: Person = new Person("Mary", 28)
    val john: Person = new Person("John", 30)

    val bobbie: Person = Person.newborn("Bobbie", mary, john)

    bobbie.greet
}

