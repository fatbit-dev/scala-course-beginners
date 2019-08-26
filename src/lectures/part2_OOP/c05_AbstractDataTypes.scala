package lectures.part2_OOP

object c05_AbstractDataTypes extends App {

    // ------- Abstract -------
    abstract class Animal {
        val creatureType: String = "wild" // non-abstract
        def eat: Unit // abstract
    }

    class Dog extends Animal {
        override val creatureType: String = "canine"
        override def eat: Unit = println("crunch, crunch!")
    }


    // ------- Traits -------
    trait Carnivore {
        val preferredMeal: String = "fresh stuff" // non-abstract
        def eat(animal: Animal): Unit // abstract

    }

    trait ColdBlooded

    class Crocodile extends Animal with Carnivore with ColdBlooded {
        override val creatureType: String = "amphibian"
        override def eat: Unit = println("grrrunch, grrrunch!")

        override def eat(animal: Animal): Unit = println(s"I'm a croc, and I'm eating ${animal.creatureType}!")
    }

    val dog: Dog = new Dog
    val croc: Crocodile = new Crocodile
    croc.eat(dog)

    // Traits vs. Abstract Classes
    // - Both allow the definition of non-abstract members.
    // 1. Traits do not have constructor parameters.
    // 2. A class can only extend one class, but it can inherit many traits.
    // 3. Traits === Behavior, Abstract Class === Type of Thing
}
