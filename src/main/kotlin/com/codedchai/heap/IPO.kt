package com.codedchai.heap

import java.util.*

fun main() {
    data class Project(val capital: Int, val profit: Int)

    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        var availableCapital = w
        val projects = profits.indices.map { profitIndex ->
            Project(capital[profitIndex], profits[profitIndex])
        }.sortedBy { it.capital }

        // Max-heap to store profits
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        var index = 0
        // Main loop to select up to k projects
        for (j in 0 until k) {
            // Add all profitable projects that we can afford
            while (index < projects.size && projects[index].capital <= availableCapital) {
                maxHeap.add(projects[index].profit)
                index++
            }

            // If no projects can be funded, break out of the loop
            if (maxHeap.isEmpty()) break

            // Otherwise, take the project with the maximum profit
            availableCapital += maxHeap.poll()
        }

        return availableCapital
    }
}