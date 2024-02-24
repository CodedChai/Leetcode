package com.codedchai.graph

fun main() {
  findCheapestPrice(
    4, arrayOf(
      intArrayOf(0, 1, 100), intArrayOf(1, 2, 100), intArrayOf(2, 0, 100), intArrayOf(1, 3, 600), intArrayOf(2, 3, 200)
    ), 0, 3, 1
  ).also { println(it) }

  findCheapestPrice(
    5, arrayOf(
      intArrayOf(4, 1, 1), intArrayOf(1, 2, 3), intArrayOf(0, 3, 2), intArrayOf(0, 4, 10), intArrayOf(3, 1, 1),
      intArrayOf(1, 4, 3)
    ), 2, 1, 1
  ).also { println(it) }

  findCheapestPrice(
    10, arrayOf(
      intArrayOf(3, 4, 4), intArrayOf(2, 5, 6), intArrayOf(4, 7, 10), intArrayOf(9, 6, 5), intArrayOf(7, 4, 4),
      intArrayOf(6, 2, 10), intArrayOf(6, 8, 6), intArrayOf(7, 9, 4), intArrayOf(1, 5, 4), intArrayOf(1, 0, 4),
      intArrayOf(9, 7, 3), intArrayOf(7, 0, 5), intArrayOf(6, 5, 8), intArrayOf(1, 7, 6), intArrayOf(4, 0, 9),
      intArrayOf(5, 9, 1), intArrayOf(8, 7, 3), intArrayOf(1, 2, 6), intArrayOf(4, 1, 5), intArrayOf(5, 2, 4),
      intArrayOf(1, 9, 1), intArrayOf(7, 8, 10), intArrayOf(0, 4, 2), intArrayOf(7, 2, 8)
    ), 6, 0, 7
  ).also { println(it) }
}

/**
 * @param n: number of flights
 * @param flights: triple of starting city, ending city, cost
 * @param src: id of starting city
 * @param dst: id of destination city
 * @param k: maximum number of stops
 */
fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
  val flightPaths = buildFlightPaths(flights)

  val eligibleFlightPaths = flightPaths.associateBy { it.cityId }
  if (eligibleFlightPaths[src] == null) {
    return -1
  }
  val queue = mutableListOf(FlightPathManager(eligibleFlightPaths[src]!!))
  val flightOptions = hashSetOf<Int>()
  val visitedPaths: HashSet<List<Int>> = hashSetOf()
  while (queue.isNotEmpty()) {
    val currentFlightPath = queue.removeFirst()

    if (currentFlightPath.visitedCities.size > k ||
      !visitedPaths.add(currentFlightPath.visitedCities + currentFlightPath.currentCity.cityId)
    ) {
      continue
    }

    if (currentFlightPath.currentCity.cityId == dst) {
      flightOptions.add(currentFlightPath.cost)
    }

    currentFlightPath.currentCity.paths.forEach { potentialPath ->
      val potentialNewCost = potentialPath.cost + currentFlightPath.cost

      if (potentialPath.toCityId == dst) {
        flightOptions.add(potentialNewCost)
      } else if (potentialPath.toCityId !in currentFlightPath.visitedCities) {
        eligibleFlightPaths[potentialPath.toCityId]?.let { newCity ->
          val visitedCities = currentFlightPath.visitedCities + currentFlightPath.currentCity.cityId
          val newFlightPath = FlightPathManager(
            currentCity = newCity,
            visitedCities = visitedCities,
            cost = potentialNewCost
          )
          queue.add(newFlightPath)
        }
      }
    }
  }
  println(visitedPaths)
  return flightOptions.minOrNull() ?: -1
}

private fun buildFlightPaths(
  flights: Array<IntArray>,
) = flights.groupBy { it[0] }.map { (cityId, flight) ->
  val paths = flight.map {
    FlightToCityCost(
      toCityId = it[1],
      cost = it[2],
    )
  }
  FlightPath(
    cityId = cityId,
    paths = paths
  )
}

data class FlightPathManager(
  val currentCity: FlightPath,
  val visitedCities: List<Int> = emptyList(),
  val cost: Int = 0,
)

data class FlightPath(
  val cityId: Int,
  val paths: List<FlightToCityCost>,
)

data class FlightToCityCost(
  val toCityId: Int,
  val cost: Int,
)