import java.lang.IllegalStateException

private const val FILE_NAME = "Day01.txt"
private val digits: List<String> = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

fun trebuchet1(): Int {
    return readFile(FILE_NAME)
        .sumOf {
            10 * it.first(Char::isDigit).digitToInt() + it.last(Char::isDigit).digitToInt()
        }
}

fun trebuchet2(): Int {
    return readFile(FILE_NAME)
        .sumOf {
            firstDigit(it) * 10 + firstDigit(it, true)
        }
}

private fun firstDigit(calibrationValue: CharSequence, reverse: Boolean = false): Int {
    val range = if (reverse) calibrationValue.indices.reversed() else calibrationValue.indices
    for (i in range) {
        if (calibrationValue[i].isDigit()) return calibrationValue[i].digitToInt()

        val digit = digits.firstOrNull {
            i + it.length <= calibrationValue.length &&
                    calibrationValue.substring(i, i + it.length) == it
        }
        if (digit != null) return digits.indexOf(digit) + 1
    }
    throw IllegalStateException()
}

fun main() {
    println(trebuchet1())
    println(trebuchet2())
}