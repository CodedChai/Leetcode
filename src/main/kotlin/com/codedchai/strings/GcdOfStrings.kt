package com.codedchai.strings

fun main() {
  gcdOfStrings("ABABAB", "ABAB").also { println(it) }
}

fun gcdOfStrings(str1: String, str2: String): String {
  if (str1 + str2 != str2 + str1) {
    return ""
  }

  return str1.substring(0 until gcd(str1.length, str2.length))
}

fun gcd(n1: Int, n2: Int): Int {
  var a = n1
  var b = n2

  while (b != 0) {
    val temp = b
    b = a % b
    a = temp
  }

  return a
}