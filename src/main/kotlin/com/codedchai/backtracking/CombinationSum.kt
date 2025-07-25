package com.codedchai.backtracking

class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        val results = mutableListOf<List<Int>>()
        val currentList = mutableListOf<Int>()

        fun backtrack(currentIndex: Int, currentTarget: Int) {
            if (currentTarget < 0 || currentIndex >= candidates.size || currentList.size > 150) {
                return
            }
            if (currentTarget == 0) {
                results.add(currentList.toList())
                return
            }

            currentList.add(candidates[currentIndex])
            backtrack(currentIndex, currentTarget - candidates[currentIndex])

            currentList.removeLast()
            backtrack(currentIndex + 1, currentTarget)
        }

        backtrack(0, target)
        return results
    }
}