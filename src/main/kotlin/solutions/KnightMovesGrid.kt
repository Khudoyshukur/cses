package solutions

import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().trim().toInt()
    val board = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(0, 0))
    val seen = BooleanArray(n * n)
    seen[0] = true

    val r = intArrayOf(-2, -2, 2, 2, 1, -1, 1, -1)
    val c = intArrayOf(1, -1, 1, -1, -2, -2, 2, 2)

    while (queue.isNotEmpty()) {
        val (idx, moves) = queue.remove()
        val row = idx / n
        val col = idx % n
        board[row][col] = minOf(board[row][col], moves)

        for (i in r.indices) {
            val newRow = row + r[i]
            val newCol = col + c[i]

            if (isValidIndex(newRow, newCol, n)) {
                val idx = newRow * n + newCol
                if (seen[idx].not()) {
                    queue.add(idx to (moves + 1))
                    seen[idx] = true
                }
            }
        }
    }

    println(board.map { it.joinToString(separator = " ") }.joinToString(separator = "\n"))
}

private fun isValidIndex(r: Int, c: Int, n: Int): Boolean {
    return r in (0 until n) && c in (0 until n)
}