package com.codedchai.graph

fun main() {
    data class Coordinate(
        val x: Int,
        val y: Int,
    ) {
        fun neighbors(): List<Coordinate> {
            return listOf(
                copy(x = x + 1),
                copy(x = x - 1),
                copy(y = y + 1),
                copy(y = y - 1),
            )
        }
    }

    fun numIslands(grid: Array<CharArray>): Int {
        val coordGrid = grid.flatMapIndexed { y, chars ->
            chars.mapIndexed { x, char ->
                Coordinate(x, y) to (char == '1')
            }
        }.toMap()

        var numIslands = 0
        val queue = mutableListOf<Coordinate>()
        val visited = hashSetOf<Coordinate>()

        val potentialCoordinates = coordGrid.entries.filter { (_, value) -> value }.map { it.key }

        for (coordinate in potentialCoordinates) {
            if (coordinate in visited) {
                continue
            }
            queue.add(coordinate)
            visited.add(coordinate)
            while (queue.isNotEmpty()) {
                val currentCoord = queue.removeFirst()

                val validNeighbors = currentCoord.neighbors().filter { neighbor ->
                    coordGrid[neighbor] == true && visited.add(neighbor)
                }
                queue.addAll(validNeighbors)
            }
            numIslands++
        }
        return numIslands
    }
}