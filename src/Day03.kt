fun main() {
    fun convertToPriorityPoint(item: Char): Int {
        //convert to Ascii
        val asciiVal = item.code
        return if (asciiVal < 97) { //upper case convert
//        println("converting $item upper $asciiVal  ->  ${asciiVal-38}")
//            65 - 90 A - Z -> 27 - 52
            asciiVal - 38
        } else { // lower case convert
//            97 - 123 a - z -> 1 - 26
//        println("converting $item lower $asciiVal  ->  ${asciiVal-96}")
            asciiVal - 96
        }

    }

    fun part1(input: List<String>): Int {
        val compartment1 = hashSetOf<Char>()
        var total = 0

        for (rucksack in input) {
            compartment1.clear()
            val midpoint = rucksack.length / 2
            rucksack.forEachIndexed { index, item ->
                if (index < midpoint) { // compartment 1
                    compartment1.add(item)
                } else { // compartment 2
                    if (compartment1.contains(item)) {
                        total += convertToPriorityPoint(item)
                        //remove from list 1, that item type has been marked already
                        compartment1.remove(item)
                    }
                }
            }
        }
//        println("Total is $total")
        return total
    }


    fun part2(input: List<String>): Int {
        val compartment1 = hashSetOf<Char>()
        var total = 0
//        println("part2 ****")
        input.windowed(3, 3){
            window ->
            val intersections = window[0].toSet()
                .intersect(window[1].toSet())
                .intersect(window[2].toSet())

            total += convertToPriorityPoint(intersections.first())
        }

        return total
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
