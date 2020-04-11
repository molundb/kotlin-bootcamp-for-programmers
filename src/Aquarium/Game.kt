package src.Aquarium

fun main(args: Array<String>) {
    val game = Game()

    while(true) {
        print("Enter a direction: n/s/e/w: ")
        game.makeMove(readLine())
    }
}

enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END,
}

class Game {

    var path: MutableList<Direction> = mutableListOf(Direction.START)

    private val north = { path.add(Direction.NORTH) }
    private val south = { path.add(Direction.SOUTH) }
    private val east = { path.add(Direction.EAST) }
    private val west = { path.add(Direction.WEST) }

    val end = {
        path.add(Direction.END)
        print("Game Over: ")
        println(path)
        path.clear()
        false
    }

    private fun move(where: () -> Boolean) {
        where.invoke()
    }

    fun makeMove(move: String?) {
        when (move) {
            "n" -> move(north)
            "s" -> move(south)
            "e" -> move(east)
            "w" -> move(west)
            else -> move(end)
        }
    }
}