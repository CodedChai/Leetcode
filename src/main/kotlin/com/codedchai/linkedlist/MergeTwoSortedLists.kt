package com.codedchai.linkedlist

import com.codedchai.ListNode

fun main() {

}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
  if (list1 == null && list2 == null) {
    return null
  }
  return when {
    list1 == null -> list2
    list2 == null -> list1
    list1.`val` < list2.`val` -> {
      list1.next = mergeTwoLists(list1.next, list2)
      list1
    }

    else -> {
      list2.next = mergeTwoLists(list1, list2.next)
      list2
    }
  }
}