package org.example

fun main() {
  twoSum(listOf(2, 7, 11, 15).toIntArray(), 22)
}

fun twoSum(nums: IntArray, target: Int): IntArray {
  val visited = hashMapOf<Int, Int>()

  var tailIndex = 0
  var answer = listOf(0, 1)
  nums.asList().windowed(2, 1).forEach { (tail, head) ->
    visited[tail] = tailIndex
    tailIndex++
    visited[target - head]?.also {
      answer = listOf(it, tailIndex)
      return@forEach
    }
  }

  return answer.toIntArray()
}