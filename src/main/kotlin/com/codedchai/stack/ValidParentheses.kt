package com.codedchai.stack

fun main() {
  isValid(
    "()[]{}[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]]])"
  ).also { print(it) }
}

fun isValid(s: String): Boolean {
  if (s.length % 2 != 0) {
    return false
  }
  val stack = ArrayDeque<Char>()
  val pushChars = hashSetOf('(', '[', '{')
  val popToPushPair = hashMapOf(
    Pair(')', '('),
    Pair('}', '{'),
    Pair(']', '[')
  )

  return s.all {
    if (it in pushChars) {
      stack.add(it)
      true
    } else {
      popToPushPair[it] == stack.removeLastOrNull()
    }
  } && stack.isEmpty()
}