package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    var leftSum = 0L
    var rightSum = 0L
    var leftNums = mutableListOf<Int>()
    var rightNums = mutableListOf<Int>()

    for (i in n downTo 1) {
        if (leftSum <= rightSum) {
            leftNums.add(i)
            leftSum += i
        } else {
            rightNums.add(i)
            rightSum += i
        }
    }


    if (leftSum != rightSum) {
        println("NO")
    } else {
        println("YES")

        println(leftNums.size)
        println(leftNums.joinToString(separator = " "))

        println(rightNums.size)
        println(rightNums.joinToString(separator = " "))
    }
}