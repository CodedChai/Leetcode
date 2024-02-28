package com.codedchai.math

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
  kthFactor(12, 3).also { println(it) }
  kthFactor(7, 2).also { println(it) }
  kthFactor(4, 4).also { println(it) }
}

fun kthFactor(n: Int, k: Int): Int {
  var currentK = k
  val sqrtOfN = ceil(sqrt(n.toFloat())).toInt()
  val sqrtOfNFloor = floor(sqrt(n.toFloat())).toInt()
  for (i in 1 until sqrtOfN) {
    if (n % i == 0 && --currentK == 0) {
      return i
    }
  }
  for (i in sqrtOfNFloor downTo 1) {
    if (n % i == 0 && --currentK == 0) {
      return n / i
    }
  }

  return -1
}