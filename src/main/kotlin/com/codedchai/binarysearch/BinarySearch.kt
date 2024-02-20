package com.codedchai.binarysearch

fun main() {
  search(listOf(-1, 0, 3, 5, 9, 12).toIntArray(), 9).also { println(it) }
  search(listOf(-1, 0, 3, 5, 9, 12).toIntArray(), 2).also { println(it) }
}

fun search(nums: IntArray, target: Int): Int {
  var lowerPointer = 0
  var higherPointer = nums.size
  while (lowerPointer < higherPointer) {
    val pivotIdx = (lowerPointer + higherPointer) / 2
    val numAtPivotPoint = nums[pivotIdx]
    when {
      numAtPivotPoint == target -> return pivotIdx
      numAtPivotPoint > target -> higherPointer = pivotIdx
      numAtPivotPoint < target -> lowerPointer = pivotIdx + 1
    }
  }

  return -1
}