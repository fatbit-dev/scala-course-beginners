package lectures.part2_OOP

object c07_AnonymousClasses extends App {

    abstract class Animal {
        def eat: Unit
    }

    // Animal is an Anonymous class
    val funnyAnimal: Animal = new Animal {
        override def eat: Unit = println("hahahaha, ñam, ñam!")
    }

    println(s"funnyAnimal.getClass = ${funnyAnimal.getClass}")
    // "funnyAnimal.getClass = class lectures.part2_OOP.c07_AnonymousClasses$$anon$1"
    // The compiler created a class on the fly, with a funny name $$anon$1

    // What happens behind the scenes is something like this:
    //
    // class c07_AnonymousClasses$$anon$1 extends Animal {
    //   override def eat: Unit = println("hahahaha, ñam, ñam!")
    // }
    //
    // val funnyAnimal: Animal = new c07_AnonymousClasses$$anon$1
    // ...

    class Person(name: String) {
        def sayHi: Unit = println(s"Hi, my name is ${name}, and I'm here to help!")
    }

    val joe = new Person("Joe")
    print("joe.sayHi = ")
    joe.sayHi

    val jim = new Person("Jim") {
        override def sayHi: Unit = println(s"Hello, I'm Jimmy!")
    }

    print("jim.sayHi = ")
    jim.sayHi

    // Anonymous Classes recap:
    //
    // - We can instantiate types, and override fields and methods on the fly.
    // - Works for traits and classes (whether they are abstract or not).
    //
    // - Rules:
    //   - pass in required constructor arguments, if needed.
    //   - implement all abstract fields/methods.

    // And we can do funny things:
    trait Poison {
        def color: String
    }

    abstract class Snake

    val viper = new Snake with Poison {
        override def color = "green"
    }

    println(s"viper.color = ${viper.color}")

    // So we can do this for traits and classes:
    val specialPoison = new Poison {
        override def color: String  = "Alice Cooper :)"
    }

    println(s"specialPoison.color = ${specialPoison.color}")
    
    val python = new Snake {
        def color: String = "Green and brown"
    }

    println(s"python.color = ${python.color}")
}
