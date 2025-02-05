package com.codedchai.topologicalsort

fun main() {

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val adjacencyMap = mutableMapOf<Int, List<Int>>()
        val inDegreeMap = mutableMapOf<Int, Int>()

        val allCourses = prerequisites.flatMap { (dependencyPrereq, course) ->
            listOf(dependencyPrereq, course)
        }.toSet()

        allCourses.forEach { inDegreeMap[it] = 0 }

        prerequisites.forEach { (dependencyPrereq, courseId) ->
            adjacencyMap[courseId] = adjacencyMap.getOrDefault(courseId, emptyList()) + dependencyPrereq
            inDegreeMap[dependencyPrereq] = inDegreeMap[dependencyPrereq]!! + 1
        }

        val topologicalOrder = mutableListOf<Int>()
        // Prefill this with random courses we gotta take but have no prereqs
        val backfillCourses = (0 until numCourses).map { it }.filter { it !in allCourses }.reversed()
        topologicalOrder.addAll(backfillCourses)

        val availableCourses = mutableListOf<Int>()

        val startingCourses = inDegreeMap.entries.filter { (_, inDegree) ->
            inDegree == 0
        }.map { (course, _) -> course }
        startingCourses.forEach { inDegreeMap.remove(it) }
        availableCourses.addAll(startingCourses)

        while (availableCourses.isNotEmpty()) {
            val course = availableCourses.removeFirst()
            topologicalOrder.add(course)
            adjacencyMap[course]?.forEach { nextCourse ->
                inDegreeMap[nextCourse] = inDegreeMap[nextCourse]!! - 1
            }
            val nextCourses = inDegreeMap.entries.filter { (_, inDegree) ->
                inDegree == 0
            }.map { (course, _) -> course }
            nextCourses.forEach { inDegreeMap.remove(it) }

            availableCourses.addAll(nextCourses)
        }

        return if (topologicalOrder.size == numCourses) {
            topologicalOrder.toIntArray()
        } else {
            intArrayOf()
        }
    }

    println(findOrder(2, arrayOf(intArrayOf(1, 0))).toList())
}