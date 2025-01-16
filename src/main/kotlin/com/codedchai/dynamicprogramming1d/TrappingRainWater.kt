package com.codedchai.dynamicprogramming1d

fun main() {

    fun trapForInterval(height: IntArray, startIndex: Int, endIndex: Int): Int {
        var rainDropSum = 0
        var currentMaxHeight = 0

        val loopProgression = if (startIndex < endIndex) {
            startIndex..endIndex
        } else {
            startIndex downTo endIndex
        }

        for (index in loopProgression) {
            if (height[index] > currentMaxHeight) {
                currentMaxHeight = height[index]
            }
            rainDropSum += currentMaxHeight - height[index]
        }

        return rainDropSum
    }

    fun trap(height: IntArray): Int {
        val maxHeight = height.max()
        val maxHeightIndex = height.indexOf(maxHeight)

        val left = trapForInterval(height, 0, maxHeightIndex)
        val right = trapForInterval(height, height.size - 1, maxHeightIndex)

        return left + right
    }

    val result = trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2))
    println(result)
}