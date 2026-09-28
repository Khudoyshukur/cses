package solutions

fun main() {
    val board = Array(8) { CharArray(8) { '+' } }


    var row = 0
    while (row < 8) {
        val line = readlnOrNull() ?: break
        for (i in line.indices) {
            board[row][i] = line[i]
        }
        row++
    }

    fun diaL(row: Int, col: Int): Int {
        return if (col >= row) { // upper
            col - row
        } else { // lower
            7 + (row - col)
        }
    }

    fun diaR(row: Int, col: Int): Int {
        val newCol = row
        val newRow = 7 - col

        return diaL(newRow, newCol)
    }

    fun set(num: Int, index: Int): Int {
        return num or (1 shl index)
    }
    fun isSet(num: Int, index: Int): Boolean {
        return (num and (1 shl index)) != 0
    }

    fun possibleWays(
        board: Array<CharArray>,
        rowPlacing: Int,
        colPlacing: Int,
        diaLeftPlacing: Int,
        diaRightPlacing: Int,
        remaining: Int,
        index: Int
    ): Long {
        if (remaining == 0) return 1L
        if (index >= board.size * board.size) {
            return 0L
        }

        val row = index / board.size
        val col = index % board.size

        var possible = 0L

        // put if possible
        if (board[row][col] == '.') {
            val diaL = diaL(row, col)
            val diaR = diaR(row, col)
            val canPlace = !isSet(rowPlacing, row) && !isSet(colPlacing, col) &&
                    !isSet(diaLeftPlacing, diaL) && !isSet(diaRightPlacing, diaR)

            if (canPlace) {
                board[row][col] = '+'

                possible += possibleWays(
                    board,
                    set(rowPlacing, row),
                    set(colPlacing, col),
                    set(diaLeftPlacing, diaL),
                    set(diaRightPlacing, diaR),
                    remaining - 1,
                    index + 1
                )

                board[row][col] = '.'
            }
        }

        // skip
        possible += possibleWays(board, rowPlacing, colPlacing, diaLeftPlacing,diaRightPlacing, remaining, index + 1)

        return possible
    }

    val ways = possibleWays(
        board,
        0,
        0,
        0,
        0,
        8,
        0
    )
    println(ways)
}