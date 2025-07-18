package com.codedchai.math

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false
        }

        var givenNumber = x
        var reversedNumber = 0
        while (givenNumber > reversedNumber) {
            reversedNumber = reversedNumber * 10 + givenNumber % 10
            givenNumber /= 10
        }

        return (givenNumber == reversedNumber || givenNumber == (reversedNumber / 10))
    }

}

fun main() {
    val solution = PalindromeNumber()
    println(solution.isPalindrome(-121))
    println(solution.isPalindrome(121))
    println(solution.isPalindrome(1234))
}