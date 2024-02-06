package com.codedchai.twopointers

fun main() {
  listOf("racecar", "nascar", "t", "pittap", " ", "A man, a plan, a canal: Panama", "0P")
    .map { isPalindrome(it) }
    .forEach { println(it) }
}

fun isPalindrome(s: String): Boolean {
  val validString = s.filter { it.isLetterOrDigit() }.lowercase()
    .ifBlank { return true }

  return (0..validString.length / 2).all { i ->
    validString[i] == validString[validString.length - 1 - i]
  }
}