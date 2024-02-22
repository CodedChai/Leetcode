package com.codedchai.trees

import com.codedchai.TreeNode
import kotlin.math.max

fun maxDepth(root: TreeNode?): Int {
  root ?: return 0
  return max(maxDepth(root.left), maxDepth(root.right)) + 1
}

