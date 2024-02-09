package com.codedchai.linkedlist

fun main() {
  val head = ListNode(5)
  val tail = ListNode(2)
  head.next = tail

  reverseList(head).also { printNodes(it) }
}

fun printNodes(head: ListNode?) {
  var currentNode = head
  while (currentNode != null) {
    println(currentNode.`val`)
    currentNode = currentNode.next
  }
}

/**
 * 1 2 3 4 5
 * 1 -> 2 -> null
 * 2 -> 1 -> null
 *
 * val tmp = 1.next
 * tmp.next = 1
 * 1.next = null (or prev)
 * current = tmp
 */

fun reverseList(head: ListNode?): ListNode? {
  var currentNode = head
  var previousNode: ListNode? = null
  while (currentNode != null) {
    val nextNode = currentNode.next
    currentNode.next = previousNode
    previousNode = currentNode
    currentNode = nextNode
  }
  return previousNode
}

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}