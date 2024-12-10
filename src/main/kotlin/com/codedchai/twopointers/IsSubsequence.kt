package com.codedchai.twopointers

fun main() {
    fun isSubsequence(s: String, t: String): Boolean {
        var stringToMatchIndex = 0
        return s.all { charToMatch ->
            while (stringToMatchIndex < t.length) {
                val charToCheck = t[stringToMatchIndex]
                stringToMatchIndex++
                if (charToMatch == charToCheck) {
                    return@all true
                }
            }
            false
        }
    }

    println(isSubsequence("abcde", "ace"))
    println(isSubsequence("abc", "ahbgdc"))
}