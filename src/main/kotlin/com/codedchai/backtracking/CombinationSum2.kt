package com.codedchai.backtracking

class CombinationSum2 {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        val currentList = mutableListOf<Int>()

        candidates.sort()
        val size = candidates.size
        fun backtrack(currentIndex: Int, currentTarget: Int) {
            if (currentTarget == 0) {
                results.add(currentList.toList())
                return
            }

            if (currentIndex >= size || currentTarget < 0) {
                return
            }

            for (i in currentIndex until size) {
                val candidate = candidates[i]
                if (candidate > currentTarget) {
                    // We know for a fact that none of the following will work since it is sorted
                    break
                }
                if (i > currentIndex && candidate == candidates[i - 1]) {
                    continue
                }

                currentList.add(candidate)
                backtrack(i + 1, currentTarget - candidates[i])
                currentList.removeLast()
            }
        }

        backtrack(0, target)

        return results
    }
}

fun main() {
    with(CombinationSum2()) {
        combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8).also { println(it) }
        combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5).also { println(it) }
    }
}