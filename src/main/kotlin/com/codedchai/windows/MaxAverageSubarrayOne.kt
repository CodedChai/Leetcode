package com.codedchai.windows

fun main() {
  findMaxAverage(listOf(1, 2, 3).toIntArray(), 2)
    .also { println(it) }
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
  return nums.asSequence().windowed(k, 1).maxOf { it.sum() } / k.toDouble()
}