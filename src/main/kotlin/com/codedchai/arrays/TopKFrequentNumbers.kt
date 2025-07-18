package com.codedchai.arrays

class TopKFrequentNumbers {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        return nums.groupBy { it }.entries.toList()
            .sortedByDescending { it.value.size }
            .take(k)
            .map { it.value.first() }
            .toIntArray()
    }
}

fun main() {
    val solution = TopKFrequentNumbers()
    println(solution.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2))
}