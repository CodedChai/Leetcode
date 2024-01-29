package com.codedchai.arrays

fun main() {
  twoSum(listOf(2, 7, 11, 15).toIntArray(), 22)
}

fun twoSum(nums: IntArray, target: Int): IntArray {
  val visited = hashMapOf<Int, Int>()

  var answer = listOf(0, 1)
  nums.asList().forEachIndexed { index, num ->
    visited[target - num]?.also {
      answer = listOf(it, index)
      return@forEachIndexed
    }
    visited[num] = index
  }

  return answer.toIntArray()
}