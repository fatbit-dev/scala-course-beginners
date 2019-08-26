package lectures.part1_basics

object c06_Default_and_Named_Arguments extends App {

    // Default value for the acc parameter
    def factorial(n: Int, acc: Int = 1): Int = {
        if (n >= 1) acc
        else factorial(n - 1, n * acc)
    }

    val fact10 = factorial(10)

    // We cannot declare default values for leading parameters (compiler error):
    //def savePicutre(format: String = "png", w: Int, h: Int): Unit = {


    def savePicutre(format: String = "png", w: Int = 1920, h: Int = 1080): Unit = {
        println(s"saving picture => format: $format     w: $w     h: $h")
    }

    // savePicutre(800, 600) // Compiler is confused here: it doesn't know
    // savePicture("jpg")    // where to apply the passed parameter/s

    // We can use named parameters to specify which default value to overwrite:
    savePicutre(format = "jpg")
    savePicutre(w = 800, h = 600)
    savePicutre(w = 1024)
}
