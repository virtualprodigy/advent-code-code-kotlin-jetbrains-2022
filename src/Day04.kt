fun main() {


    data class Range(val start: Int, val end: Int)
    fun part1(input: List<String>): Int {
        var total = 0
        for(pair in input){
            val ranges = pair.split(",").map { str ->
                val split = str.split("-")
                Range(split[0].toInt(),split[1].toInt())
            }
            val range1 = ranges[0]
            val range2 = ranges[1]
            if( (range1.start >= range2.start && range1.end <= range2.end)
                || (range2.start >= range1.start && range2.end <= range1.end)){
                total += 1
            }
        }
        return total
    }


    fun part2(input: List<String>): Int {
        var total = 0
        for(pair in input){
            val ranges = pair.split(",").map { str ->
                val split = str.split("-")
                Range(split[0].toInt(),split[1].toInt())
            }

            val range1 = ranges[0]
            val range2 = ranges[1]
            if( ( (range1.start >= range2.start && range1.start <= range2.end)
                || (range1.end >= range2.start && range1.end <= range2.end) )
                || ( (range2.start >= range1.start && range2.start <= range1.end)
                        || (range2.end >= range1.start && range2.end <= range1.end) )
                    ){
                total += 1
            }
        }

//        println("total is $total")
        return total
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
