package com.codedchai.arrays

fun main() {
  canPlaceFlowers(listOf(0, 0, 0).toIntArray(), 2)
    .also { println(it) }
}

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
  if (n <= 0) {
    return true
  }

  if (flowerbed.size == 1) {
    return n <= 1 && flowerbed[0] == 0
  }

  if (flowerbed.size == 2) {
    return n == 1 && flowerbed.all { it == 0 }
  }

  var numFlowersPlaced = 0
  if (flowerbed[0] == 0 && flowerbed[1] == 0) {
    numFlowersPlaced++
    flowerbed[0] = 1
  }
  if (flowerbed[flowerbed.size - 2] == 0 && flowerbed[flowerbed.size - 1] == 0) {
    numFlowersPlaced++
    flowerbed[flowerbed.size - 1] = 1
  }
  for (i in 1 until flowerbed.size - 1) {
    val canPlaceFlower = (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0)
    if (canPlaceFlower) {
      flowerbed[i] = 1
      numFlowersPlaced++
    }
  }

  return numFlowersPlaced >= n
}