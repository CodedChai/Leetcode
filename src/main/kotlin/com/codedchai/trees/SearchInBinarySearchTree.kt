package com.codedchai.trees

import com.codedchai.TreeNode

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
  var matchingNode: TreeNode? = null
  fun search(root: TreeNode?) {
    root ?: return
    if (root.`val` == `val`) {
      matchingNode = root
      return
    }
    search(root.left)
    search(root.right)
  }
  search(root)
  return matchingNode
}