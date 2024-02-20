package com.codedchai.dynamicprogramming1d

fun main() {
  climbStairs(2).also { println(it) }
  climbStairs(200).also { println(it) }
}

fun climbStairs(n: Int): Int {
  if (n == 0 || n == 1) {
    return 1
  }

  var previous = 1
  var current = 1
  repeat(n - 1) {
    val temp = current
    current += previous
    previous = temp
  }

  return current
}