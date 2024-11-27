package com.codedchai.twopointers

fun main() {
    merge(listOf(1, 2, 2, 3).toIntArray(), 4, listOf(2, 4).toIntArray(), 2)
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var nums1Idx = m - 1
    var nums2Idx = n - 1
    var finalIdx = m + n - 1
    while (nums2Idx >= 0) {
        nums1[finalIdx--] = if (nums1Idx < 0 || nums1[nums1Idx] < nums2[nums2Idx]) {
            nums2[nums2Idx--]
        } else {
            nums1[nums1Idx--]
        }
    }
}