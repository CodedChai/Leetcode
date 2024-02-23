package com.codedchai.trees

import com.codedchai.TreeNode

fun invertTree(root: TreeNode?): TreeNode? {
  root ?: return null
  val temp = root.left
  root.left = root.right
  root.right = temp
  invertTree(root.left)
  invertTree(root.right)
  return root
}