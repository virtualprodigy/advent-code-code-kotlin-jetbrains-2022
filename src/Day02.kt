import kotlin.math.max

fun main() {
    val winningsMap = hashMapOf<String, Int>(
        "Lose" to 0,
        "Win" to 6,
        "Draw" to 3
    )

    val fightResultsMap = hashMapOf<String, String>(
        "ax" to "Draw",
        "ay" to "Win",
        "az" to "Lose",

        "bx" to "Lose",
        "by" to "Draw",
        "bz" to "Win",

        "cx" to "Win",
        "cy" to "Lose",
        "cz" to "Draw",
    )

    val playerMoveToPoints = hashMapOf<String, Int>(
        "x" to 1,
        "y" to 2,
        "z" to 3
    )

    // Maps the player requested outcome to a move
    // X means you need to lose
    // Y means you need to end the round in a draw,
    // Z means you need to win
    val matchOutcomeToPlayerMoveMap = hashMapOf<String, String>(
        "ax" to "z",
        "ay" to "x",
        "az" to "y",

        "bx" to "x",
        "by" to "y",
        "bz" to "z",

        "cx" to "y",
        "cy" to "z",
        "cz" to "x",
    )

    fun part1(input: List<String>): Int {
        var totalPoints = 0
        for (battle in input) {
            val moveList = battle.lowercase().split(" ")
            val enemyMove = moveList[0]
            val playerMove = moveList[1]
            totalPoints +=
                fightResultsMap[enemyMove + playerMove].run {
                    winningsMap[this]!! + playerMoveToPoints[playerMove]!!
                }

        }
        return totalPoints
    }

    fun part2(input: List<String>): Int {
        var totalPoints = 0
        for (battle in input) {
            val moveList = battle.lowercase().split(" ")
            val enemyMove = moveList[0]
            val playerMove = matchOutcomeToPlayerMoveMap[moveList[0]+moveList[1]]

            totalPoints +=
                fightResultsMap[enemyMove + playerMove].run {
                    winningsMap[this]!! + playerMoveToPoints[playerMove]!!
                }

        }
        return totalPoints
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
