package com.codedchai.windows

import kotlin.math.max

fun main() {
  maxProfit(listOf(7, 1, 5, 3, 6, 4).toIntArray()).also { println(it) }
  maxProfit(listOf(7, 6, 4, 3, 1).toIntArray()).also { println(it) }
  maxProfit(listOf(1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9).toIntArray()).also { println(it) }
}

fun maxProfit(prices: IntArray): Int {
  var maxPrice = 0
  var buyIndex = 0
  var sellIndex = 1
  while (sellIndex < prices.size) {
    // if we're buying higher than  we're selling that's NO GOOD, we have a better price to buy at, otherwise update our currentMaxProfit
    if (prices[buyIndex] >= prices[sellIndex]) {
      buyIndex = sellIndex
    } else {
      maxPrice = max(maxPrice, prices[sellIndex] - prices[buyIndex])
    }
    sellIndex++
  }

  return maxPrice
}