fun main() {

    val phoneNumbers = listOf(
        "1234567890",
        "123",
        "",
        "0987654321"
    )

    // 1. Filter valid phone numbers - 10 digits
    val validNumbers = phoneNumbers.filter { it.length == 10 }

    println("Valid phone numbers:")
    validNumbers.forEach {
        println(it)
    }

    // 2. Print all phone numbers, if invalid print NAN
    println("\nAll phone numbers:")

    phoneNumbers
        .map {
            if (it.length == 10) it else "NAN"
        }
        .forEach {
            println(it)
        }
}