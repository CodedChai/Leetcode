package com.codedchai.dynamicprogramming1d

fun main() {
  minCostClimbingStairs(listOf(10, 15, 20).toIntArray()).also { println(it) }
  minCostClimbingStairs(listOf(1, 2).toIntArray()).also { println(it) }
  minCostClimbingStairs(listOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1).toIntArray()).also { println(it) }
}

fun minCostClimbingStairs(cost: IntArray): Int {
  val bestCostCache = mutableListOf<Int>()

  for (i in cost.indices) {
    if (i < 2) {
      bestCostCache.add(cost[i])
    } else {
      val bestCostToStep = bestCostCache.takeLast(2).min() + cost[i]
      bestCostCache.add(bestCostToStep)
    }
  }

  return bestCostCache.takeLast(2).min()
}