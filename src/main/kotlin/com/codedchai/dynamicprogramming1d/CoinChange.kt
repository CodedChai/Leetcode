package com.codedchai.dynamicprogramming1d

fun main() {
  coinChange(listOf(1, 2, 5).toIntArray(), 11).also { println(it) }
  coinChange(listOf(2).toIntArray(), 3).also { println(it) }
  coinChange(listOf(1).toIntArray(), 0).also { println(it) }
  coinChange(listOf(186, 419, 83, 408).toIntArray(), 6249).also { println(it) }
}

fun coinChange(coins: IntArray, amount: Int): Int {
  val remainingAmountToCoinsUsed = mutableMapOf(Pair(amount, 0))
  val remainingAmountQueue = mutableListOf(amount)

  while (remainingAmountQueue.isNotEmpty()) {
    val currentRemainingAmount = remainingAmountQueue.removeFirst()
    val currentCoinsUsed = remainingAmountToCoinsUsed[currentRemainingAmount] ?: 0
    coins.forEach { coin ->
      val newRemainingAmount = currentRemainingAmount - coin
      if (newRemainingAmount >= 0) {
        val currentCoinsInCache = remainingAmountToCoinsUsed[newRemainingAmount] ?: Int.MAX_VALUE
        if (currentCoinsUsed + 1 < currentCoinsInCache) {
          remainingAmountQueue.add(newRemainingAmount)
          remainingAmountToCoinsUsed[newRemainingAmount] = currentCoinsUsed + 1
        }
      }

    }
  }

  return remainingAmountToCoinsUsed[0] ?: -1
}