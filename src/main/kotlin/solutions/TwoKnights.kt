package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()

    val answers = mutableListOf<Long>()
    for (k in 1..n) { answers.add(validCounts3(k)) }

    println(answers.joinToString(separator = "\n"))
}

// time com: O(n * k^4) ~ O(1^4 + 2^4 + ... n^4) ~ (n^4) NOT GOOD
private fun validCounts(k: Int): Int {
    var ans = 0

    val squares = k * k
    for (i in 0 until squares) {
        val iRow = i / k
        val iCol = i % k

        for (j in (i + 1) until squares) {
            val jRow = j / k
            val jCol = j % k

            if ((jRow == iRow + 1) && ((jCol == iCol - 2) || (jCol == iCol + 2))) continue
            if ((jRow == iRow + 2) && ((jCol == iCol - 1) || (jCol == iCol + 1))) continue
            ans++
        }
    }

    return ans
}


// O(k)
private fun validCounts2(k: Long): Long {
    val squares = k * k
    val totalPlacings = ((1 + (squares - 1)) * (squares - 1) / 2)

    var possiblePlacings = 0L
    for (col in 0 until k) {
        if ((col + 1) < k) {
            possiblePlacings += maxOf(0, k - 2)
            possiblePlacings += maxOf(0, k - 2)
        }

        if ((col + 2) < k) {
            possiblePlacings += maxOf(0, k - 1)
            possiblePlacings += maxOf(0, k - 1)
        }
    }

    return totalPlacings - possiblePlacings
}

// O(1)
private fun validCounts3(k: Long): Long {
    val squares = k * k
    val totalPlacings = ((1 + (squares - 1)) * (squares - 1) / 2)

    var possiblePlacings = 0L

    possiblePlacings = when(k) {
        1L -> 0
        2L -> 0
        else -> (k - 2L) * (2 * (k - 2) + 2 * (k - 1)) + (2 * (k - 2))
    }

    return totalPlacings - possiblePlacings
}