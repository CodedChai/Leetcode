package com.codedchai.binarysearch

fun main() {
  findPeakElement(intArrayOf(1, 2, 3, 1)).also { println(it) }
}

fun findPeakElement(nums: IntArray): Int {
  when {
    nums.size == 1 -> return 0
    nums[0] > nums[1] -> return 0
    nums[nums.size - 1] > nums[nums.size - 2] -> return nums.size - 1
  }

  var start = 1
  var end = nums.size - 2
  while (start <= end) {
    val mid = start + (end - start) / 2
    when {
      nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1] -> return mid
      nums[mid] < nums[mid - 1] -> end = mid - 1
      nums[mid] < nums[mid + 1] -> start = mid + 1
    }
  }
  return -1
}