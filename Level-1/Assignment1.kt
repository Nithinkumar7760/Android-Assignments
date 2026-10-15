fun main() {

    val data = "Hi! How are you?"

    // 1. how many vowels in the string
    var vowels = 0

    for (ch in data) {
        val isVowel = when (ch.lowercaseChar()) {
            'a', 'e', 'i', 'o', 'u' -> true
            else -> false
        }

        if (isVowel) {
            vowels++
        }
    }

    println("Number of vowels: $vowels")

    // 2. how many spaces
    var spaces = 0

    for (ch in data) {
        if (ch == ' ') {
            spaces++
        }
    }

    println("Number of spaces: $spaces")
}