package Aquarium

fun main(args: Array<String>) {
    val curry = Curry("curry", "mild")
    val chili = Curry("chili", "spicy")

    println("Color: ${curry.color}")

    val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
        SpiceContainer(Curry("Red Curry", "medium")),
        SpiceContainer(Curry("Green Curry", "spicy")))

    for (element in spiceCabinet) println(element.label)
}

abstract class Spice(
    val name: String,
    private val spiciness: String = "mild",
    color: SpiceColor): SpiceColor by color {

    abstract fun prepareSpice()
}

class Curry(name: String, spiciness: String, color: SpiceColor = YellowSpiceColor) :
    Spice(name, spiciness, color), Grinder {
    override fun prepareSpice() {
        grind()
    }

    override fun grind() {
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: String
}

object YellowSpiceColor : SpiceColor {
    override val color = "Yellow"
}

data class SpiceContainer(val spice: Spice) {

    val label = spice.name
}