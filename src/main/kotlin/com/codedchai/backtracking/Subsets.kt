package com.codedchai.backtracking

class Subsets {

    fun subsets(nums: IntArray): List<List<Int>> {

        val results = mutableListOf<List<Int>>()
        val currentList = mutableListOf<Int>()

        fun backtrack(currentIndex: Int) {

            if (currentIndex !in nums.indices) {
                results.add(currentList.toList())
                return
            }

            // include current element
            currentList.add(nums[currentIndex])
            backtrack(currentIndex + 1)
            // backtrack by removing the element we just added
            currentList.removeLast()
            // exclude current element
            backtrack(currentIndex + 1)
        }

        backtrack(0)

        return results
    }

    fun subsetsFunctional(nums: IntArray): List<List<Int>> {

        val results = mutableListOf<List<Int>>()

        fun backtrack(currentIndex: Int, currentList: List<Int>) {

            if (currentIndex !in nums.indices) {
                results.add(currentList)
                return
            }

            val updatedList = currentList + nums[currentIndex]

            backtrack(currentIndex + 1, updatedList)
            backtrack(currentIndex + 1, currentList)
        }

        backtrack(0, emptyList())

        return results
    }
}

fun main() {
    with(Subsets()) {
        subsets(intArrayOf(1, 2, 3)).also { println(it) }
    }
}