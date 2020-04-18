import java.util.*

fun main(args: Array<String>) {
    println(if (args[0].toInt() < 12) "Good morning, Kotlin" else "Good night, Kotlin")
    feedTheFish()
    eagerExample()
}

fun eagerExample() {
    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    val eager = decorations.filter { it[0] == 'p' }
    println(eager)

    // apply filter lazily
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println(filtered)
    println(filtered.toList())

    // apply map lazily
    val lazyMap = decorations.asSequence().map {
        println("map: $it")
    }

    println(lazyMap)
    println("first: ${lazyMap.first()}")
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")

    if(shouldChangeWater(day)) {
        println("Change the water today")
    }

    dirtyProcessor()
}

fun getDirtySensorReading() = 20

var dirty = 20

val waterFilter: (Int) -> Int = { dirty -> dirty / 2}
fun feedFish(dirty: Int) = dirty +10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty) {dirty ->
        dirty + 50
    }
}




fun shouldChangeWater(
    day: String,
    temperature: Int = 22,
    dirty: Int = getDirtySensorReading()): Boolean {

    val isTooHot = temperature > 30
    val isDirty = dirty > 30
    val isSunday = day == "Sunday"

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun randomDay() : String {
    val week = listOf ("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun fishFood (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun canAddFish (tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    val b = (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
    println(b)
    return b
}