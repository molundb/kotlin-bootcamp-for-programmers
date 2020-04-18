import kotlin.random.Random

fun main(args: Array<String>) {
    val rollDice = { sides: Int ->
        if (sides == 0) 0
        else Random.nextInt(sides) + 1
    }
    val rollDice2: (Int) -> Int = { sides ->
        if (sides == 0) 0
        else Random.nextInt(sides) + 1
    }

    gamePlay(rollDice2(4))
}

fun gamePlay(rolledDice: Int) {
    print(rolledDice)
}