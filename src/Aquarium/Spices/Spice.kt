package Aquarium

fun main(args: Array<String>) {
    val curry = Curry("curry", "mild")

    println("Color: ${curry.color}")
}

abstract class Spice(
    private val name: String,
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