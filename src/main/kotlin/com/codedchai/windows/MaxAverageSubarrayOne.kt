package com.codedchai.windows

import kotlin.math.max

fun main() {
  findMaxAverage(listOf(0, 1, 1, 3, 3).toIntArray(), 4)
    .also { println(it) }
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
  var currentSum = 0
  var tailIndex = 0
  var headIndex = 0

  while (headIndex < k) {
    currentSum += nums[headIndex]
    headIndex++
  }
  var currentMax = currentSum

  while (headIndex < nums.size) {
    currentSum += nums[headIndex] - nums[tailIndex]
    currentMax = max(currentMax, currentSum)
    tailIndex++
    headIndex++
  }

  return currentMax / k.toDouble()
}