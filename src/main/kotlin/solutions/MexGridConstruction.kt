package solutions

import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().trim().toInt()
    val matrix = Array(n) { IntArray(n) { -1 } }
    matrix[0][0] = 0

    val queue: Queue<Int> = LinkedList()
    queue.add(0)
    val added = BooleanArray(n * n)
    added[0] = true

    val r = intArrayOf(0, 1)
    val c = intArrayOf(1, 0)

    while (queue.isNotEmpty()) {
        val idx = queue.remove()
        val row = idx / n
        val col = idx % n

        val nums = mutableListOf<Int>()
        for (c in 0 until col) {
            nums.add(matrix[row][c])
        }

        for (r in 0 until row) {
            nums.add(matrix[r][col])
        }

        nums.sort()
        var target = nums.size
        for (i in nums.indices) {
            if (i != nums[i]) {
                target = i
                break
            }
        }
        matrix[row][col] = target

        for (k in 0 until 2) {
            val newRow = row + r[k]
            val newCol = col + c[k]

            if (isValidIndex(newRow, newCol, n)) {
                val newIdx = newRow * n + newCol
                if (!added[newIdx]) {
                    queue.add(newIdx)
                    added[newIdx] = true
                }
            }
        }
    }

    println(matrix.map { it.joinToString(separator = " ") }.joinToString(separator = "\n"))
}

private fun isValidIndex(row: Int, col: Int, n: Int): Boolean {
    return row in (0 until n) && col in (0 until n)
}