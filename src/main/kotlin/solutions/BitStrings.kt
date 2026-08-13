package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)
    val n = scan.nextInt()

    var res = 0
    val MOD = 1_000_000_007

    var calc = 1
    for (i in 0 until n) {
        res = (res % MOD + calc) % MOD
        calc = ((calc % MOD) * (2 % MOD)) % MOD
    }

    print(res + 1)
}