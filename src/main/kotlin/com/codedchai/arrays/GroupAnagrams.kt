package com.codedchai.arrays

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { str -> str.groupingBy { it }.eachCount() }
            .values.toList()
    }
}

fun main() {
    val solution = GroupAnagrams()

    println(solution.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
}