package com.codedchai.heap

import java.util.*

fun main() {
    data class Station(
        val position: Int,
        val fuel: Int,
    )

    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        val transformedStations = stations.map { (position, fuel) ->
            Station(position, fuel)
        }

        val maxHeap = PriorityQueue<Int>(compareByDescending { it })

        var refuelingStops = 0
        var currentFuel = startFuel
        var currentPos = 0
        for (station in transformedStations) {
            currentFuel -= (station.position - currentPos)
            currentPos = station.position

            while (currentFuel < 0 && maxHeap.isNotEmpty()) {
                currentFuel += maxHeap.poll()
                refuelingStops++
            }
            if (currentFuel < 0) {
                return -1
            }

            maxHeap.add(station.fuel)
        }
        currentFuel -= (target - currentPos)

        while (currentFuel < 0 && maxHeap.isNotEmpty()) {
            currentFuel += maxHeap.poll()
            refuelingStops++
        }
        if (currentFuel < 0) {
            return -1
        }
        return refuelingStops
    }

    println(minRefuelStops(1, 1, emptyArray()))
}