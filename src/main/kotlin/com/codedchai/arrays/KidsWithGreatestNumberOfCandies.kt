package com.codedchai.arrays

fun main() {
  kidsWithCandies(listOf(2, 3, 5, 1, 3).toIntArray(), 3).also { println(it) }
}

fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
  val max = candies.max()
  return candies.map { candy -> candy + extraCandies >= max }
}