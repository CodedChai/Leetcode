package com.codedchai.windows

import kotlin.math.max

fun main() {
  lengthOfLongestSubstring("abcabcbb").also { println(it) }
  lengthOfLongestSubstring("bbbbb").also { println(it) }
  lengthOfLongestSubstring("pwwkew").also { println(it) }
  lengthOfLongestSubstring("aab").also { println(it) }
}

fun lengthOfLongestSubstring(s: String): Int {
  if (s.isEmpty()) {
    return 0
  }

  if (s.length == 1) {
    return 1
  }

  var currentMax = 0
  var trailingIndex = 0
  val currentCharSet = hashSetOf<Char>()

  for (index in s.indices) {
    while (!currentCharSet.add(s[index])) {
      currentCharSet.remove(s[trailingIndex])
      trailingIndex++
    }

    currentMax = max(currentMax, currentCharSet.size)
  }

  return currentMax
}