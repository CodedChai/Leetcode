package com.codedchai.arrays

fun main() {
  containsDuplicate(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).toIntArray()).also { println(it) }
}

fun containsDuplicate(nums: IntArray): Boolean {
  val numberCache = hashSetOf<Int>()
  for (i in nums.indices) {
    if (!numberCache.add(nums[i])) {
      return true
    }
  }

  return false
}