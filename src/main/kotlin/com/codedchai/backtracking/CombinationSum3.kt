package com.codedchai.backtracking

class CombinationSum3 {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        val currentList = mutableListOf<Int>()

        fun backtrack(currentNumber: Int, currentTarget: Int) {
            if (currentTarget == 0 && currentList.size == k) {
                results.add(currentList.toList())
                return
            }
            if (currentList.size > k || currentNumber > 9 || currentNumber > currentTarget) {
                return
            }

            currentList.add(currentNumber)
            backtrack(currentNumber + 1, currentTarget - currentNumber)

            currentList.removeLast()
            backtrack(currentNumber + 1, currentTarget)
        }

        backtrack(1, n)

        return results
    }
}

fun main() {
    with(CombinationSum3()) {
        combinationSum3(3, 7).also { println(it) }
        combinationSum3(3, 9).also { println(it) }
    }
}