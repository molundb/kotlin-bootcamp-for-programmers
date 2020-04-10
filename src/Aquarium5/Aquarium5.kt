package src.Aquarium5

data class Fish (var name: String)

fun main (args: Array<String>) {
    fishExamples()
}

fun fishExamples() {
    val fish = Fish("splashy")

    myWith (fish.name) {
        println(capitalize())
    }

    println(fish.run {name})

    println(fish.apply{})

    val fish2 = Fish("splashy").apply { name = "Sharky" }
    println(fish2.name)

    println(fish.let { it.name.capitalize() }
        .let { it + "fish" }
        .let { it.length }
        .let { it + 31 })

    val numbers = listOf(1,2,3,4,5,6,7,8,9,0)
    print(numbers.divisibleBy {
        it.rem(3)
    })
}

fun myWith(name: String, block: String.() -> Unit) {

    name.block()
}

fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}