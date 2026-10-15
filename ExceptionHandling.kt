fun getNumber(data: String): Int {
    try {
        return data.toInt()
    } catch (e: Exception) {
        println("Invalid number")
        return 0
    }
}

fun main() {
    println(getNumber("12"))
    println(getNumber("a1as"))
}