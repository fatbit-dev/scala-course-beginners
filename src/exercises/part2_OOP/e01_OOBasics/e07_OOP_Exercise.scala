package exercises.part2_OOP

import java.util.NoSuchElementException


abstract class FatList[+A] { // COVARIANT
    def head: A
    def tail: FatList[A]
    def isEmpty: Boolean
    def add[B >: A](elem: B): FatList[B] = new FatCons(elem, this)
    def printElements: String

    override def toString: String = s"[${printElements}]"

    def map[B](transformer: MyTransformer[A, B]): FatList[B]
    def flatMap[B](transformer: MyTransformer[A, FatList[B]]): FatList[B]
    def filter(predicate: MyPredicate[A]): FatList[A]

    def ++[B >: A](list: FatList[B]): FatList[B]
}

object FatEmpty extends FatList[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: FatList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    override def add[B >: Nothing](elem: B): FatList[B] = new FatCons(elem, FatEmpty)
    def printElements: String = "[]"

    def map[B](transformer: MyTransformer[Nothing, B]): FatList[B] = FatEmpty
    def flatMap[B](transformer: MyTransformer[Nothing, FatList[B]]): FatList[B] = FatEmpty
    def filter(predicate: MyPredicate[Nothing]): FatList[Nothing] = FatEmpty

    def ++[B >: Nothing](list: FatList[B]): FatList[B] = list
}

class FatCons[+A](h: A, t: FatList[A]) extends FatList[A] { // COVARIANT
    def head: A = h
    def tail: FatList[A] = t
    def isEmpty: Boolean = false
    //def append[B >: A](elem: B): FatList[B] = new FatCons(h, t.append(elem))

    override def printElements: String = {
        if (t.isEmpty) s"${h}"
        else s"${h}, ${t.printElements}"
    }

    def filter(predicate: MyPredicate[A]): FatList[A] = {
        if (predicate.test(h)) new FatCons(h, t.filter(predicate))
        else t.filter(predicate)
    }

    def map[B](transformer: MyTransformer[A, B]): FatList[B] = {
        new FatCons(transformer.transform(h), t.map(transformer))
    }

    def flatMap[B](transformer: MyTransformer[A, FatList[B]]): FatList[B] = {
        transformer.transform(head) ++ t.flatMap(transformer)
    }

    def ++[B >: A](list: FatList[B]): FatList[B] = {
        new FatCons(h, t ++ list)
    }
}

trait MyPredicate[-T] {
    def test(p: T): Boolean //= return p == true
}

trait MyTransformer[-A, B] {
    def transform(a: A): B
}

/*
class EvenPredicate extends MyPredicate[Double] {
    override def test(p: Double): Boolean = p > 0
    //def test(p: Int): Boolean = p > 0
}

class StringToIntTransformer extends MyTransformer[String, Int] {
    // _root_.scala.Predef.String
    override def transform(a: String): Int = a.toInt
}
*/


object e07_OOP_Exercise extends App {
    //val sti = new StringToIntTransformer
    //val ep = new EvenPredicate
    val listOfIntegers: FatList[Int] = new FatCons(1, new FatCons(2, new FatCons(3, FatEmpty)))
    val intList: FatList[Int] = new FatCons(4, new FatCons(5, FatEmpty))
    val listOfStrings: FatList[String] = new FatCons("Hey", new FatCons("Scala", new FatCons("People!", FatEmpty)))

    println(listOfIntegers)
    println(listOfStrings.toString)

    println(listOfIntegers.map(new MyTransformer[Int, Int] {
        override def transform(a: Int): Int = a * 2
    }).toString)

    println(listOfIntegers.filter(new MyPredicate[Int] {
        override def test(p: Int): Boolean = p % 2 == 0
    }).toString)

    println((listOfIntegers ++ intList).toString)

    println(listOfIntegers.flatMap(new MyTransformer[Int, FatList[Int]] {
        override def transform(a: Int): FatList[Int] = new FatCons(a, new FatCons(a + 1, FatEmpty))
    }).toString)
}
