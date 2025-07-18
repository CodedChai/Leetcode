package com.codedchai.arrays

import kotlin.math.max

class LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        val setOfNumbers = nums.toHashSet()
        var longestConsecutiveSequence = 0

        for (number in setOfNumbers) {
            // Only start at the lowest
            if ((number - 1) !in setOfNumbers) {
                // increment up
                var currentNumber = number + 1
                while (currentNumber in setOfNumbers) {
                    currentNumber++
                }
                longestConsecutiveSequence = max(longestConsecutiveSequence, currentNumber - number)
            }
        }
        return longestConsecutiveSequence
    }
}

fun main() {
    with(LongestConsecutiveSequence()) {
        longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)).also { println(it) }
    }
}