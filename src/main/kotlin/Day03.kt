private const val FILE_NAME = "Day03.txt"

fun gearRatios1(): Int {
    val grid = readFile(FILE_NAME) { it.toList() }

    val currentNum = mutableListOf<Char>()
    var sum = 0
    for (r in grid.indices) {
        var c = 0
        while (c <= grid[0].lastIndex) {
            if (!grid[r][c].isDigit())  {
                currentNum.clear()
                c++
            }
            else {
                currentNum += grid[r][c]
                if (getNeighbors(r, c, grid).any { !it.isDigit() && it != '.' }) {
                    while (++c <= grid[0].lastIndex && grid[r][c].isDigit()) {
                        currentNum += grid[r][c]
                    }
                    sum += currentNum.joinToString("").toInt()
                }
                else {
                    c++
                }
            }
        }

        currentNum.clear()
    }

    return sum
}

fun gearRatios2(): Int {
    return 0
}

private fun <T> getNeighbors(row: Int, col: Int, grid: List<List<T>>): List<T> {
    val neighbors = mutableListOf<T>()

    for (r in row-1..row+1) {
        for (c in col-1..col+1) {
            if (r == row && c == col) continue

            if (r in grid.indices && c in grid[0].indices) {
                neighbors += grid[r][c]
            }
        }
    }

    return neighbors
}

fun main() {
    println(gearRatios1())
    println(gearRatios2())
}