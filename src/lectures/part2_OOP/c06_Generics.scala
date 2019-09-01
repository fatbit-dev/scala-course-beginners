package lectures.part2_OOP

object c06_Generics extends App {

    // We can have generic classes and traits.

    class FatList[A] {
        // This list uses the type A.
    }

    // Generic classes can have more than one generic type.
    class MyMap[Key, Value]

    val intList = new FatList[Int]
    val stringList = new FatList[String]

    // Generic Methods (in this case it's a companion object).
    object FatList {
        def empty[A]: FatList[A] = ???
    }

    val emptyListOfIntegers = FatList.empty[Int]

    // If B extends A, should List[B] extend List[A]?
    // --> Variance problem.
    class Animal
    class Dog extends Animal
    class Cat extends Animal

    // Can a List[Cat] extend a List[Animal]?
    // 1. yes, List[Cat] extends List[Animal] ==> COVARIANCE
    class CovariantList[+A]
    val animal: Animal = new Cat
    val animalList: CovariantList[Animal] = new CovariantList[Cat]
    // I has replaced a List[Animal] with a List[Cat]

    // animalList.add(new Dog) ??? (***) GOOD QUESTION!
    // This would pollute our list of cats. The answer is below.

    // 2. no, List[Cat] is a different thing than a List[Animal] ==> INVARIANCE
    class InvariantList[A]
    // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] // Error
    val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
    // It does not allow type replacements.

    // 3. Hell, no! But a List of Cats is indeed a List of Animals ==> CONTRAVARIANCE
    class ContravariantList[-A]
    val contraVariantList: ContravariantList[Cat] = new ContravariantList[Animal]
    // It has replaced a List[Cat] with a List[Animal].

    // Apparently this has no sense, why would I need to replace a List[Cat]
    // with a List[Animal]? Among animals there're also dogs and lizards!

    // Let's see another example, let's rename our class and our val:
    class Trainer[-A]
    val trainer: Trainer[Cat] = new Trainer[Animal]
    // This Trainer[Animal] is in fact better tan a Trainer[Cat], because he/she
    // can train animals in general, both cats and dogs.

    // What happens here is that if a trainer can workout a Cat, and I can
    // assign it a trainer for other animals.

    // Bounded types: they allow you to use your generic classes only for
    // certain types that are either a subclass of a different type, or a
    // superclass of a different type.

    // Here we present an UPPER BOUNDED TYPE of Animal.
    class Cage[A <: Animal](animal: A)
    // Here I've defined a class Cage whose type can be a subclass of Animal,
    // and it can receive a parameter of Animal type.
    val cage = new Cage(new Dog)
    // This worked because Dog is a subclass of Animal.

    class Car
    // val newCage = new Cage(new Car)  // IntelliJ don't show an error, but this won't run!
    // Basically a Car is not an Animal type (not an Animal, nor any of its
    // subclasses).

    // We can also have a LOWER BOUNDED TYPE of Animal.
    class Leash[A >: Animal](animal: A)
    // This Leash class would only accept a parameter of a superclass of Animal
    // (which we don't have in this example).

    // Bounded types solve a variant problem, which is very annoying when we want to declare
    // covariant collections. Let's see an example.
    // Let's define a MyOtherList class which is covariant on the type A.
    class MyOtherList[+A] {

        // def add(element: A): MyOtherList[A] = ???
        //
        // This does not work! It throws this error:
        // Covariant type A occurs in contravariant position in type A of value
        // element. The compiler is warning us about the (***) GOOD QUESTION
        // presented above.

        // If I have a List[Animals], which is in fact a List[Cats], what if I
        // add a Dog to it? --> It would convert the List[Cat] into a
        // List[Animal], because the list now contains a mix of Cats and Dogs.

        // This is the way to do it:
        // The add() receives a type parameter B, which is a super-type of A.
        def add[B >: A](element: B): MyOtherList[B] = ???
        // I'm explicitly saying: I have a List[A], and if I add an element of
        // type B, which is a super-type of A, then the add operation will
        // return a List[B].

        // So the answer to the (***) GOOD QUESTION is, we can do it if we
        // return a List[Animal]
    }
}
