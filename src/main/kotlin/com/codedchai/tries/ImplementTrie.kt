package com.codedchai.tries

class ImplementTrie {

    val rootNode = TrieNode()

    fun insert(word: String) {
        var currentNode = rootNode
        for (i in 0 until word.length) {
            val nextNode = currentNode.children.getOrPut(
                word[i]
            ) { TrieNode() }
            if (i == word.length - 1) {
                nextNode.isEndOfWord = true
            }
            currentNode = nextNode
        }
    }

    fun search(word: String): Boolean {
        var currentNode = rootNode
        for (char in word) {
            var nextNode = currentNode.children[char]
            if (nextNode == null) {
                return false
            }
            currentNode = nextNode
        }

        return currentNode.isEndOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var currentNode = rootNode
        for (char in prefix) {
            var nextNode = currentNode.children[char]
            if (nextNode == null) {
                return false
            }
            currentNode = nextNode
        }

        return true
    }

    data class TrieNode(
        val children: HashMap<Char, TrieNode> = hashMapOf(),
        var isEndOfWord: Boolean = false,
    )
}

fun main() {
    with(ImplementTrie()) {

    }
}

