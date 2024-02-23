package com.codedchai.trees

import com.codedchai.TreeNode
import kotlin.math.max

fun main() {
  val root = TreeNode(1)
  val left = TreeNode(2)
  root.left = left
  diameterOfBinaryTree(root).also { println(it) }
}

fun diameterOfBinaryTree(root: TreeNode?): Int {
  var diameter = 0
  fun depth(node: TreeNode?): Int {
    node ?: return 0
    val left = depth(node.left)
    val right = depth(node.right)
    diameter = max(left + right, diameter)
    return 1 + max(left, right)
  }
  depth(root)
  return diameter
}

