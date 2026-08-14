package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val t = scanner.nextInt(); scanner.nextLine()

    val res = mutableListOf<String>()
    repeat(t) {
        val test = scanner.nextLine().trim().split(" ")
        val left = test[0].toInt(); val right = test[1].toInt()

        res.add(if (possible(left, right)) "YES" else "NO")
    }

    println(res.joinToString(separator = "\n"))
}


// in one step, i can either take 2 from left and 1 from right, or 2 from right and 1 from left
// can i empty both piles????

// the sum of them should be divisible by 3. because in each step i am removing 3 piles
// also, moreSide/2 should not be greater than anotherSide
private fun possible(left: Int, right: Int): Boolean {
    if ((left + right) % 3 != 0) return false

    // a = 2 * k + 1 * l
    // b = 2 * l + 1 * k
    // a + b = 3 * k + 3 * l => a + b = 3 * (k + l) => k + l = steps

    // a - b = 2k + 1l - 2l - 1k=  k - l
    // k - l = a - b
    // k + l = (a + b) / 2 => k + l = steps

    // a = 8 b = 1
    // => k = (a - b + steps) / 2   => k = 5
    // => l = (steps - (a - b)) / 2 => l = -2

    // a = 8, b = 1 => steps = 3  => k + l = 3
    val steps = (left + right) / 3
    val aMinusB = left - right

    val k = (aMinusB + steps) / 2
    val l = (steps - aMinusB) / 2

    return k >= 0 && l >= 0
}
