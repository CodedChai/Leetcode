package com.codedchai.strings

import kotlin.math.max

fun main() {
  mergeAlternately("abc", "pqrs")
    .also { println(it) }
}

fun mergeAlternately(word1: String, word2: String): String {
  val sb = StringBuilder()

  (0 until max(word1.length, word2.length)).forEach { idx ->
    if (idx < word1.length) {
      word1[idx].also { sb.append(it) }
    }
    if (idx < word2.length) {
      word2[idx].also { sb.append(it) }
    }
  }

  return sb.toString()
}