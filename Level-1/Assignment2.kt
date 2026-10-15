fun convert(names: Array<String?>) {

    for (name in names) {

        // Explicit null check
        if (name != null) {
            println("Explicit check: ${name.uppercase()}")
        } else {
            println("Explicit check: NULL")
        }

        // Safe call operator
        println("Safe call: ${name?.uppercase()}")

        // Elvis operator
        println("Elvis: ${name?.uppercase() ?: "UNKNOWN"}")

        // Assertion operator
        if (name != null) {
            println("Assertion: ${name!!.uppercase()}")
        }

        println()
    }
}

fun main() {
    convert(arrayOf("john", null, "merry", "robert"))
}