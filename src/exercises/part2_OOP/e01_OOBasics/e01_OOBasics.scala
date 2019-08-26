package exercises.part2_OOP.e01_OOBasics

object e01_OOBasics extends App {
    val dickens = new Writer("Charles", "Dickens", 1812)
    val imposter = new Writer("Charles", "Dickens", 1812)
    val novel = new Novel("Great Expectations", 1861, dickens)

    println(novel.authorAge)
    println(s"The novel '${novel.name}' was written by ${dickens.fullname}: ${novel.isWrittenBy(dickens)}")
    println(s"The novel '${novel.name}' was written by an imposter ${imposter.fullname}: ${novel.isWrittenBy(imposter)}")

    val counter = new Counter // default value of 0
    counter.inc.print
    counter.inc.inc.inc.print
    counter.inc(10).print
}
