package com.codedchai.arrays

class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val isValidRows = board.all { row -> row.isValid() }
        val columns = (0 until board.size).map { columnIndex ->
            board.map { row -> row[columnIndex] }.toCharArray()
        }
        val isValidColumns = columns.all { column -> column.isValid() }

        for (i in 0 until 9 step 3) {
            for (j in 0 until 9 step 3) {
                val chars = mutableListOf<Char>()
                for (squareI in i until i + 3) {
                    for (squareJ in j until j + 3) {
                        chars.add(board[squareI][squareJ])
                    }
                }
                if (!chars.toCharArray().isValid()) {
                    return false
                }
            }
        }

        return isValidRows && isValidColumns
    }

    fun CharArray.isValid(): Boolean {
        val digitCount = this.count { it.isDigit() }
        val uniqueDigitCount = this.asSequence().filter { it.isDigit() }.map { it.digitToInt() }.toSet().size
        return digitCount == uniqueDigitCount
    }

}

fun main() {
    with(ValidSudoku()) {
        isValidSudoku(
            arrayOf(
                charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
            )
        ).also { println(it) }

    }
}