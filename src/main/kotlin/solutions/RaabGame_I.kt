package solutions

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val test = readln().split(" ").map { it.toInt() }
        val solution = solve(test)
        if (solution == null) {
            println("NO")
        } else  {
            println("YES")
            println(solution.map { it.joinToString(separator = " ") }.joinToString(separator = "\n"))
        }
    }
}

private fun solve(test: List<Int>): Array<IntArray>? {
    val n = test[0]
    val a = test[1]
    val b = test[2]

    if (a + b > n) return null

    val res = Array(2) { IntArray(n) }

    val tie = n - (a + b)

    repeat(tie) {
        res[0][it] = (it + 1)
        res[1][it] = (it + 1)
    }

    val startCard = tie
    val endCard = n
    repeat(a) {
        val aCard = endCard - it
        res[0][tie + it] = aCard
        res[1][tie + it] = aCard - 1

        if (res[0][tie + it] <= res[0][tie + it]) return null
    }

    repeat(b) {
        val aCard = startCard + it

        if (it == (b - 1)) {
            res[0][tie + a + it] = aCard
            res[1][tie + a + it] = aCard + 1
        } else {
            res[0][tie + a + it] = aCard
            res[1][tie + a + it] = endCard
        }

        if (res[0][tie + a + it] >= res[0][tie + a + it]) return null
    }

    return res
}