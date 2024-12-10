package com.codedchai.divideandconquer

fun main() {
    class Node(var `val`: Boolean, var isLeaf: Boolean) {
        var topLeft: Node? = null
        var topRight: Node? = null
        var bottomLeft: Node? = null
        var bottomRight: Node? = null
    }

    fun construct(grid: Array<IntArray>): Node? {
        fun dfs(r1: Int, c1: Int, width: Int): Node = if (width == 1) {
            Node(grid[r1][c1] == 1, true)
        } else {
            val newWidth = width shr 1
            val a = dfs(r1, c1, newWidth)
            val b = dfs(r1, c1 + newWidth, newWidth)
            val c = dfs(r1 + newWidth, c1, newWidth)
            val d = dfs(r1 + newWidth, c1 + newWidth, newWidth)

            if (a.isLeaf && b.isLeaf && c.isLeaf && d.isLeaf
                && a.`val` == b.`val` && b.`val` == c.`val` && c.`val` == d.`val`
            ) {
                Node(a.`val`, true)
            } else {
                val res = Node(true, false)
                res.topLeft = a
                res.topRight = b
                res.bottomLeft = c
                res.bottomRight = d
                res
            }
        }
        return dfs(0, 0, grid.size)
    }
}