package com.codedchai.windows

import kotlin.math.max

fun main() {
  findMaxAverage(listOf(0, 1, 1, 3, 3).toIntArray(), 4)
    .also { println(it) }
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
  var currentMax = nums.take(k).sum()

  for (i in 1..nums.size - k) {
    var windowSum = 0
    for (j in i until i + k) {
      windowSum += nums[j]
    }
    currentMax = max(currentMax, windowSum)
  }

  return currentMax.toDouble() / k.toDouble()
}