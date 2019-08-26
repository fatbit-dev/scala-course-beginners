package lectures.part2_OOP


object c04_Inheritance extends App {

    // ------- Single class inheritance. -------
    class Animal {
        val creatureType: String = "wild"
        def eat = println("ñam, ñam")
        private def sleep = println("zzZZZzzzZZ")
        protected def groom = println("groom, groom, groom")
    }

    // Cat only can use the non-private members of Animal
    // so it can use protected and public members.
    class Cat extends Animal {}

    class Dog extends Animal {
        def bark = {
            // We can use protected methods from the superclass, but only
            // within the class. It won't be possible to invoke a protected
            // method from outside.
            groom
            println("woof, woof")
        }
    }

    val cat = new Cat
    cat.eat
    // cat.sleep // Cannot use a private method from a subclass instance.

    val dog = new Dog
    dog.bark
    // dog.groom // Cannot use a protected method from a subclass instance. We
                 // can only use it from within the subclass body,

    // ------- Constructors -------
    class Person(name: String, age: Int) {
        // Overload the constructor
        def this(name: String) = this(name, 0)
    }

    class Adult(name: String, age: Int, idCard: String) extends Person(name, age)
    // Can also extend using overloaded constructors.
    class Dreamer(name: String, age: Int, dreams: String) extends Person(name)

    // ------- Overriding -------
    class Cow extends Animal {
        override val creatureType: String = "domestic"
        override def eat: Unit = println("nom, nom, nom") // super.eat
    }

    val cow = new Cow
    cow.eat // nom, nom, nom
    println(cow.creatureType)

    // You can override even in the constructor:
    class Pig(override val creatureType: String) extends Animal {
        override def eat: Unit = println("groik, groik, groik") // super.eat
    }

    val pig = new Pig("farm")
    println(pig.creatureType)

    // Though it's equivalent, maybe it's better to use constructor parameters:
    class Sheep(sheepType: String) extends Animal {
        override val creatureType: String = sheepType
    }

    val sheep = new Sheep("easy farmimg")
    println(sheep.creatureType)

    // ------- Type substitution -------
    // Broad polymorphism
    val unknownAnimal: Animal = new Pig("porcine")
    unknownAnimal.eat // groik, groik, groik --> Always use the most overriden version of eat().

    // Let's talk about super()
    class Bull extends Animal {
        override def eat: Unit = {
            super.eat
            println("mooooik, mooooik, mooooik")
        }
    }

    val bull = new Bull
    bull.eat

    // ------- Preventing overrides -------
    // 1. Using the 'final' keyword on the member not to be overridden.
    class Animal2 {
        final def eat = println("ñam, ñam")
    }

    class Cat2 extends Animal2 {
        // override def eat: Unit = println("wtf!!") // Cannot override a superclass' final member.
    }

    // 2. Using the 'final' keyword in the class: the entire class cannot be overridden/extended.
    final class Animal3 {
        def eat: Unit = println("eat, eat, eaaaaaaat")
    }

    // class Cat3 extends Animal3 {} // Cannot extend a final class.

    // 3. Seal the class == can extend the class in THIS FILE, but prevents extension from OTHER FILES.
    sealed class AnimalSealed {
        def eat: Unit = println("seal, seal, seaaaaaaal")
    }
}
