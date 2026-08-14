package uz.safix.solutions

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    // if the number is divided by 5, then it will add one 0
    // if the number is divided by 25, then it will add two 0

    val fiveDividers = mutableListOf<Int>()
    var initial = 5
    while (initial <= n) {
        fiveDividers.add(initial)

        initial *= 5
    }

    // lets say we have n numbers divided by 5
    // k numbers are divided by 25
    // z numbers divided by 125 etc.

    val countByDividers = IntArray(fiveDividers.size)
    var sum = 0
    for (i in fiveDividers.lastIndex downTo 0) {
        countByDividers[i] = n / fiveDividers[i] - sum

        sum += countByDividers[i]
    }

    var res = 0
    for (i in countByDividers.indices) {
        res += countByDividers[i] * (i + 1)
    }

    println(res)
}