package com.codedchai.trees

import com.codedchai.TreeNode

fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
  root ?: return false
  if (isIdenticalTree(root, subRoot)) {
    return true
  }

  return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
}

/**
 * Literally the same as isSameTree but gave it a different name so they don't collide
 */
fun isIdenticalTree(root: TreeNode?, subRoot: TreeNode?): Boolean {
  if (root == null || subRoot == null) {
    return root?.`val` == subRoot?.`val`
  }
  return if (root.`val` == subRoot.`val`) {
    isIdenticalTree(root.left, subRoot.left) && isIdenticalTree(root.right, subRoot.right)
  } else {
    false
  }
}