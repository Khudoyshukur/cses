package uz.safix.solutions

import java.util.Scanner
import kotlin.math.abs

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt(); scanner.nextLine();
    val w = scanner.nextLine().trim().split(" ").map { it.toLong() }

    val total = w.sum()

    fun minDiff(index: Int, currSum: Long): Long {
        if (index >= n) return abs(currSum - (total - currSum))

        // include
        val include = minDiff(index + 1, currSum + w[index])

        // skip
        val skip = minDiff(index + 1, currSum)

        return minOf(skip, include)
    }

    println(minDiff(0, 0L))
}