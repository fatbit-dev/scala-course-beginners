package exercises.part2_OOP.e01_OOBasics

class Writer(val name: String, val surname: String, val year: Int) {
    def fullname(): String = name + " " + surname
}
