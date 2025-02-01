package com.codedchai.arrays

import kotlin.math.max
import kotlin.math.min

fun main() {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val intervalRanges = intervals.sortedBy { it[0] }.map { it[0]..it[1] }

        val acceptableRanges = mutableListOf<IntRange>()
        for (i in intervalRanges.indices) {
            val currentInterval = intervalRanges[i]
            val overlap = acceptableRanges.find { existingRange ->
                currentInterval.first in existingRange || currentInterval.last in existingRange
            }
            if (overlap == null) {
                acceptableRanges.add(currentInterval)
                continue
            }
            val newInterval = min(overlap.first, currentInterval.first)..max(overlap.last, currentInterval.last)
            acceptableRanges.remove(overlap)
            acceptableRanges.add(newInterval)
        }
        println(acceptableRanges)
        return acceptableRanges.map { intArrayOf(it.first, it.last) }
            .toTypedArray()
    }

    val input = arrayOf(intArrayOf(1, 4), intArrayOf(0, 2), intArrayOf(3, 5))
    merge(input)
}