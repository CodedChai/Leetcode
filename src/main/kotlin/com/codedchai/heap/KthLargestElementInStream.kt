package com.codedchai.heap

import java.util.PriorityQueue

fun main() {
  val kthLargest = KthLargestElementInStream(3, intArrayOf(4, 5, 8, 2))
  println(kthLargest.add(3))
  println(kthLargest.add(5))
  println(kthLargest.add(10))
  println(kthLargest.add(9))
  println(kthLargest.add(4))
}

data class KthLargestElementInStream(val k: Int, val nums: IntArray) {
  val heap = PriorityQueue<Int>(k)
    .apply { addAll(nums.toList()) }

  fun add(`val`: Int): Int {
    heap.add(`val`)
    while (heap.size > k) {
      heap.poll()
    }

    return heap.peek()
  }
}