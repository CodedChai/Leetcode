package com.codedchai.trees

import com.codedchai.TreeNode

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
  root ?: return null
  if (root.`val` == `val`) {
    return root
  }

  return searchBST(root.left, `val`) ?: searchBST(root.right, `val`)
}