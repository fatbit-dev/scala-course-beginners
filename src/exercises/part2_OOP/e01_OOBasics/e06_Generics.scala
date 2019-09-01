package exercises.part2_OOP

import java.util.NoSuchElementException

// We must implement a List of Integers, with the following methods:
//
//  def head: A             --> Returns the first element.
//  def tail: MyList[A]     --> Returns the remainder of the list.
//  def empty: Boolean      --> Returns true if the list is empty, false otherwise.
//  def add(A): MyList[A]   --> Returns a new list with the new element appended to it.
//  def toString: String    --> Returns a string representation of the list.
//

// Make the abstract class COVARIANT.
abstract class MyList[+A] {
    def head: A
    def tail: MyList[A]
    def isEmpty: Boolean
    def add[B >: A](elem: B): MyList[B] = new Cons(elem, this)
    def printElements: String

    override def toString: String = s"[${printElements}]"
}

object Empty extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: MyList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    override def add[B >: Nothing](elem: B): MyList[B] = new Cons(elem, Empty)
    def printElements: String = "[]"
}

// Cons is also delcared as COVARIANT, to properly extend MyList[+A]
class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
    def head: A = h
    def tail: MyList[A] = t
    def isEmpty: Boolean = false
    //def append[B >: A](elem: B): MyList[B] = new Cons(h, t.append(elem))

    override def printElements: String = {
        if (t.isEmpty) s"${h}"
        else s"${h}, ${t.printElements}"
    }
}

object e06_Generics extends App {

    val listOfInt: MyList[Int] = new Cons(1, Empty)
    val intList: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
    val listOfFloat: MyList[Float] = new Cons(1.0f, Empty)
    val listOfString: MyList[String] = new Cons("One", Empty)

    println(s"listOfInt.head = ${listOfInt.head}")
    println(s"listOfFloat.head = ${listOfFloat.head}")
    println(s"listOfString.head = ${listOfString.head}")

    println(s"intList.add(4).head = ${intList.add(4).head}")
    println(s"intList.isEmpty = ${intList.isEmpty}")

    // polymorphic call
    //println(intList.toString)
    //println(intList.add(4).toString)
    println(s"intList = ${intList}") // toString() is called by println()
    println(s"intList.add(4) = ${intList.add(4)}") // toString() is called by println()

    val goodQuestion = intList.add(7.7f)
    println(s"goodQuestion = ${goodQuestion}")

    val goodQuestion2 = intList.add(7.7f).add("Eight")
    println(s"goodQuestion2 = ${goodQuestion2}")
}
