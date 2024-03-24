package com.codedchai.heap

import java.util.PriorityQueue

fun main() {
  lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)).also { println(it) }
}

fun lastStoneWeight(stones: IntArray): Int {
  val maxHeap = PriorityQueue<Int>(reverseOrder())
  maxHeap.addAll(stones.toList())

  while (maxHeap.size >= 2) {
    val biggerRock = maxHeap.poll()
    val smallerRock = maxHeap.poll()

    if (biggerRock > smallerRock) {
      val remainingRock = biggerRock - smallerRock
      maxHeap.add(remainingRock)
    }
  }

  return maxHeap.firstOrNull() ?: 0
}