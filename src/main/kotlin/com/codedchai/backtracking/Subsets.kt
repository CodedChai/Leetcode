package com.codedchai.backtracking

class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {

        val results = mutableListOf<List<Int>>()

        fun dfs(currentIndex: Int, currentList: List<Int>) {

            if (currentIndex !in nums.indices) {
                results.add(currentList)
                return
            }

            val updatedList = currentList + nums[currentIndex]

            dfs(currentIndex + 1, updatedList)
            dfs(currentIndex + 1, currentList)

        }

        dfs(0, listOf())

        return results
    }
}

fun main() {
    with(Subsets()) {
        subsets(intArrayOf(1, 2, 3)).also { println(it) }
    }
}