package com.codedchai.windows

fun main() {
  findMaxAverage(listOf(0, 1, 1, 3, 3).toIntArray(), 4)
    .also { println(it) }
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
  var sum = 0.0
  for (i in 0 until k) {
    sum += nums[i]
  }
  var maxSum = sum
  for (i in k until nums.size) {
    sum = sum - nums[i - k] + nums[i]
    maxSum = maxOf(maxSum, sum)
  }
  return maxSum / k
}