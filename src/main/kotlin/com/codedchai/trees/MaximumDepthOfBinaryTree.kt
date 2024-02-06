package com.codedchai.trees

import kotlin.math.max

fun maxDepth(root: TreeNode?): Int {
  root ?: return 0
  return max(maxDepth(root.left), maxDepth(root.right)) + 1
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}