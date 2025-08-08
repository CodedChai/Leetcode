package com.codedchai.trees

import com.codedchai.TreeNode

class KthSmallestElementInBst {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val stack = ArrayDeque<TreeNode>()

        var currentNode = root
        while (currentNode != null) {
            stack.addLast(currentNode)
            currentNode = currentNode.left
        }

        var currentK = 0

        while (currentK < k) {
            val currentKthNode = stack.removeLast()
            currentK++;
            if (k == currentK) return currentKthNode.`val`
            var lowerNode = currentKthNode.right
            while (lowerNode != null) {
                stack.addLast(lowerNode)
                lowerNode = lowerNode.left
            }
        }

        return -1
    }
}

fun main() {
    with(KthSmallestElementInBst()) {
        // TODO
    }
}