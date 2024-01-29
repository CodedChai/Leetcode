package com.codedchai.strings

fun main() {
  mergeAlternately("abc", "pqr")
    .also { println(it) }
}

fun mergeAlternately(word1: String, word2: String): String {
  var word1Index = 0
  var word2Index = 0
  val sb = StringBuilder()

  while (word1Index < word1.length || word2Index < word2.length) {

    if ((word1Index + word2Index) % 2 == 0 && word1Index < word1.length) {
      sb.append(word1[word1Index])
      word1Index++
    } else if (word2Index < word2.length) {
      sb.append(word2[word2Index])
      word2Index++
    } else {
      sb.append(word1[word1Index])
      word1Index++
    }
  }

  return sb.toString()
}