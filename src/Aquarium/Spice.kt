package Aquarium

class Spice(val name: String, val spiciness: String = "mild") {

    val heat: Int
        get() = when (spiciness) {
            "mild" -> 1
            "medium" -> 2
            "hot" -> 3
            else -> 0
        }

    init {
        println("Name: ${this.name}. spciciness: ${this.spiciness}")
    }
}

fun makeSalt() = Spice("salt")