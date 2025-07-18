package com.codedchai.graph

import java.util.*

class ReconstructItinerary {
    // Eulerian path
    fun findItinerary(tickets: List<List<String>>): List<String> {

        // Lexigraphical naming is the tie breaker so we must sort
        val graph = mutableMapOf<String, PriorityQueue<String>>()
        tickets.forEach { ticket ->
            graph.computeIfAbsent(ticket[0]) {
                PriorityQueue<String>()
            }.add(ticket[1])
        }

        // EVERY flight starts at "JFK"
        val route = mutableListOf<String>()

        fun dfs(airportCode: String) {
            val destinations = graph[airportCode]

            while (destinations != null && destinations.isNotEmpty()) {
                dfs(destinations.poll())
            }

            route.add(0, airportCode)
        }

        dfs("JFK")
        return route
    }
}

fun main() {
    val solution = ReconstructItinerary()

    println(
        solution.findItinerary(
            listOf(
                listOf("MUC", "LHR"),
                listOf("JFK", "MUC"),
                listOf("SFO", "SJC"),
                listOf("LHR", "SFO")
            )
        )
    )
}