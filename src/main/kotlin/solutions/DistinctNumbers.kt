package solutions

import java.util.Arrays
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLine().trim().toInt();
    val nums = scanner.nextLine().split(" ").map{ it.toInt() }.toIntArray()

    Arrays.sort(nums)

    var ans = 1

    for (i in 1 until n) {
        if (nums[i] != nums[i - 1]) {
            ans++
        }
    }

    println(ans)
}