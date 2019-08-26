package exercises.part2_OOP.e01_OOBasics

import java.text.SimpleDateFormat
import java.util.Calendar
import scala.util.Try

class Novel(val name: String, releaseYear: Int, author: Writer) {

    def tryToOptInt( s: String ): Option[Int] = Try(s.toInt).toOption

    def tryToInt( s: String ): Int = {
        tryToOptInt(s) match {
            case Some(i) => i
            case None => currentYear()
        }
    }

    def currentYear(): Int = {
        val dateFormat: SimpleDateFormat = new SimpleDateFormat("y") // d-M-y
        val currentYearStr: String = dateFormat.format(Calendar.getInstance().getTime())
        currentYearStr.toInt
    }

    def authorAge(): Int = currentYear() - author.year

    def isWrittenBy(a: Writer): Boolean = a == author //.fullname()

    def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}
