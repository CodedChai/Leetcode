package com.codedchai.dynamicprogramming1d

fun main() {
  coinChange(listOf(1, 2, 5).toIntArray(), 11).also { println(it) }
  coinChange(listOf(2).toIntArray(), 3).also { println(it) }
  coinChange(listOf(1).toIntArray(), 0).also { println(it) }
  coinChange(listOf(186, 419, 83, 408).toIntArray(), 6249).also { println(it) }
}

fun coinChange(coins: IntArray, amount: Int): Int {
  val amountCache = (0..amount).map { Int.MAX_VALUE }.toMutableList()
  amountCache[0] = 0
  (1..amount).forEach { amountToCheck ->
    val valueToAdd = coins.minOf { coin ->
      val index = amountToCheck - coin
      if (index < 0) {
        Int.MAX_VALUE
      } else {
        val existingValue = amountCache[index]
        if (existingValue == Int.MAX_VALUE) {
          Int.MAX_VALUE
        } else {
          existingValue + 1
        }
      }
    }
    amountCache[amountToCheck] = valueToAdd
  }
  val minCoins = amountCache.last()
  return if (minCoins == Int.MAX_VALUE) {
    -1
  } else {
    minCoins
  }
}