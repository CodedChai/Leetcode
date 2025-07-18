package com.codedchai.arrays

class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        repeat(nums.size) { answer.add(1) }

        var currentProduct = 1
        nums.forEachIndexed { index, number ->
            answer[index] *= currentProduct
            currentProduct *= number
        }
        currentProduct = 1
        nums.reversed().forEachIndexed { index, number ->
            val currentIndex = nums.size - index - 1
            answer[currentIndex] *= currentProduct
            currentProduct *= number
        }

        return answer.toIntArray()
    }
}