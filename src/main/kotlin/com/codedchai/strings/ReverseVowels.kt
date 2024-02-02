package com.codedchai.strings

fun main() {
  reverseVowels("leetcode").also { println(it) }
}

fun reverseVowels(s: String): String {
  val vowels = hashSetOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

  val vowelStack = ArrayDeque<Char>()

  s.forEach { char ->
    if (char in vowels) {
      vowelStack.add(char)
    }
  }
  val sb = StringBuilder()
  s.forEach { char ->
    if (char in vowels) {
      sb.append(vowelStack.removeLast())
    } else {
      sb.append(char)
    }
  }

  return sb.toString()
}