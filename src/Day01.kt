import kotlin.math.max

fun main() {
    fun part1(input: List<String>): Int {
        var max = 0
        var temp = 0
        input.forEachIndexed { index, str ->
            if (str.isNotEmpty()) {
                temp += str.toInt()
                if (index == input.size - 1) {
                    max = max(max, temp)
                }
            } else {
                max = max(max, temp)
                temp = 0
            }

        }
        return max
    }

    fun part2(input: List<String>): Int {

        val totals = mutableListOf<Int>()
        var temp = 0
        input.forEachIndexed { index, str ->
            if (str.isNotEmpty()) {
                temp += str.toInt()
                if (index == input.size - 1) {
                    totals.add(temp)
                }
            } else {
                totals.add(temp)
                temp = 0
            }

        }
        totals.sortDescending()

        val sum = totals[0] + totals[1] + totals[2]
//        print("sum $sum  collection $totals")
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
