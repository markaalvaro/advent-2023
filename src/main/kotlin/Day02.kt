private const val FILE_NAME = "Day02.txt"

private val colors = mapOf("red" to 12, "green" to 13, "blue" to 14)

fun cubeConundrum1(): Int {
    return readFile(FILE_NAME).sumOf {
        val id = it.substring(0, it.indexOf(":")).split(" ")[1].toInt()
        val isValid = it.substring(it.indexOf(":") + 1)
            .trim()
            .split(";")
            .flatMap { set -> set.split(",") }
            .all { countAndColor ->
                val (count, color) = countAndColor.trim().split(" ")
                colors[color]!! >= count.toInt()
            }

        if (isValid) id else 0
    }
}

fun cubeConundrum2(): Int {
    return readFile(FILE_NAME).sumOf { game ->
        game.substring(game.indexOf(":") + 1)
            .trim()
            .split(";")
            .flatMap { set -> set.split(",") }
            .map { countAndColor ->
                val (count, color) = countAndColor.trim().split(" ")
                color to count
            }
            .groupingBy { colorToCount -> colorToCount.first }
            .fold(0) { current, group ->
                val count = group.second.toInt()
                if (current == 0 || current < count) count else current
            }
            .values
            .reduce { current, next -> current * next }
    }
}

fun main() {
    println(cubeConundrum1())
    println(cubeConundrum2())
}