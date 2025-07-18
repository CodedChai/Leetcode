package com.codedchai.strings

class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    fun encode(strs: List<String>): String {
        return strs.joinToString("") { str ->
            str.length.toString() + "~" + str
        }
    }

    // Decodes a single string to a list of strings.
    fun decode(s: String): List<String> {
        val decodedStrings = mutableListOf<String>()
        var index = 0
        while (index < s.length) {
            val splitIndex = s.indexOf("~", index)
            val stringLength = s.substring(index, splitIndex).toInt()
            val decodedString = s.substring(splitIndex + 1, splitIndex + stringLength + 1)
            decodedStrings.add(decodedString)
            index = splitIndex + stringLength + 1
        }
        return decodedStrings
    }
}

fun main() {
    val solution = EncodeAndDecodeStrings()

    val encoded = solution.encode(listOf("Hello", "12~3", "world"))
    println(encoded)
    val decoded = solution.decode(encoded)
    println(decoded)

    val encoded2 = solution.encode(listOf("63/Rc", "h", "BmI3FS~J9#vmk", "7uBZ?7*/", "24h+X", "O "))
    println(encoded2)
    val decoded2 = solution.decode(encoded2)
    println(decoded2)
}