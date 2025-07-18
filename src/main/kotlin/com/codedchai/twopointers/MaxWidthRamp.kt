package com.codedchai.twopointers

import kotlin.math.max

fun main() {
    fun maxWidthRamp(nums: IntArray): Int {
        var bestRampWidth = 0

        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (nums[i] > nums[j]) {
                    bestRampWidth = max(bestRampWidth, j - i - 1)
                    break
                }
            }
            bestRampWidth = max(bestRampWidth, nums.size - 1 - i)
        }

        return bestRampWidth
    }
}