package com.codedchai.trees

import com.codedchai.TreeNode

fun main() {
  val rootNode = TreeNode(1)
  val leftNode = TreeNode(2)
  val rightNode = TreeNode(3)
  rootNode.left = leftNode
  rootNode.right = rightNode
  isSameTree(rootNode, rootNode).also { println(it) }
  val rootNode2 = TreeNode(1)
  rootNode.left = leftNode
  isSameTree(rootNode, rootNode2).also { println(it) }
}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
  if (p == null || q == null) {
    return p?.`val` == q?.`val`
  }
  return if (p.`val` == q.`val`) {
    isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
  } else {
    false
  }
}