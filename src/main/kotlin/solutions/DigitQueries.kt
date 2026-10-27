package solutions

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLine().trim().toInt()
    val queries = LongArray(n)
    repeat(n) {
        queries[it] = scanner.nextLine().trim().toLong()
    }

    queries.forEach {
        println(atK(it))
    }
}

private fun atK(k: Long): Long {
    // 123456789 10 11 12 13 14 15 16 17 18 19 202122232425
    // max time we could do here is 10^5
    // k can be 10^18, so linear run is useless

    // 1 digit nums will take 9
    // 22 digit nums are 90
    // 3 digit nums are 900

    // ranges like [1..9] [10..(10 + 179)] [190..]

    // after finding the number of digits, i will find exact number

    // the starting point is X, and the digit count is y
    // so, digits cover [x..(x + y - 1), ]

    // for example, 10 11 12 13 14
    // 10, each contains 10 digits
    // find at 7
    // 7 / 2 = 3
    // if there is reminder, we take 4th num, otherwise 3th num

    // after finding exact number, i can check with reminder, based on reminder, starting from end digits of number
    // we find exact digit

    var range = k
    var curr = 9L
    var digits = 1
    while (range > (curr * digits)) {
        range -= (curr * digits)

        digits++
        curr *= 10
    }

    var minNum = 1L; repeat(digits - 1) { minNum *= 10 }
    var num = (if (range % digits == 0L) (range / digits) - 1 else (range / digits)) + minNum
    val rem = range % digits

    //println("range: $range digit: $digits num: $num")

    if (rem == 0L) return num % 10
    repeat((digits - rem.toInt())) {
        num /= 10
    }

    return num % 10
}