package com.codedchai.arrays

fun main() {
  isAnagram("anagram", "nagamar").also { println(it) }
  isAnagram("car", "rat").also { println(it) }
}

fun isAnagram(s: String, t: String): Boolean {
  return s.groupBy { it } == t.groupBy { it }
}