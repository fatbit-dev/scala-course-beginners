package lectures.part2_OOP

object c06_Generics {

    class MyList[A] {
        // use the type A
    }

    class MyMap[Key, Value]

    val intList = new MyList[Int]
    val stringList = new MyList[String]

    // generic methods
    object MyList { // companion object
        def empty[A]: MyList[A] = ???
    }

    val emptyListOfIntegers = MyList.empty[Int]

    // Variance problem
    class Animal
    class Dog extends Animal
    class Cat extends Animal

    // 1. yes, List[Cat] extends List[Animal] ==> COVARIANCE
    class CovariantList[+A]
    val animal: Animal = new Cat
    val animalList: CovariantList[Animal] = new CovariantList[Cat]

    // animalList.add(new Dog) ??? Good question!

    // 2. no, List[Cat] is a different thing than a List[Animal] ==> INVARIANCE
    class InvariantList[A]
    // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] // Error
    val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
}
