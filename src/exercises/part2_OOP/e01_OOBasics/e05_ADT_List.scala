package exercises.part2_OOP.e01_OOBasics

// We must implement a List of Integers, with the following methods:
//
//  def head: Int           --> Returns the first element.
//  def tail: MyList        --> Returns the remainder of the list.
//  def empty: Boolean      --> Returns true if the list is empty, false otherwise.
//  def add(Int): MyList    --> Returns a new list with the new element appended to it.
//  def toString: String    --> Returns a string representation of the list.
//
abstract class MyList {
    def head: Int
    def tail: MyList
    def isEmpty: Boolean
    //def add(e: Int): MyList
    def add(e: Int): MyList = new Cons(e, this)

    def printElements: String

    override def toString: String = s"[${printElements}]"

    //def append[B >: A](elem: B): MyList[B]
}

object Empty extends MyList {
    def head: Int = throw new NoSuchElementException
    def tail: MyList = throw new NoSuchElementException
    def isEmpty: Boolean = true
    //def add(e: Int): MyList = new Cons(e, Empty)

    override def printElements: String = ""

    //def append[B >: Nothing](elem: B): MyList[B] = new Cons(elem, Empty)
}

class Cons(h: Int, t: MyList) extends MyList {
    def head: Int = h
    def tail: MyList = t
    def isEmpty: Boolean = false
    //def add(e: Int): MyList = new Cons(e, this)

    override def printElements: String = {
        if (t.isEmpty) s"${h}"
        else s"${h}, ${t.printElements}"
    }

    //def append[B >: A](elem: B): MyList[B] = new Cons(h, t.append(elem))
}

object e05_ADT_List extends App {
    val list = new Cons(1, Empty)
    val list2 = new Cons(1, new Cons(2, new Cons(3, Empty)))
    println(list.head)
    println(list2.tail.head)
    println(list2.add(4).head)
    println(list2.isEmpty)

    // polymorphic call
    //println(list2.toString)
    //println(list2.add(4).toString)
    println(list2) // toString() is called by println()
    println(list2.add(4)) // toString() is called by println()
}