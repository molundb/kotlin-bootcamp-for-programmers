package Aquarium

class SimpleSpice {
    val name = "curry"
    val spiciness = "mild"
    val heat: Int
        get() {
            return when(spiciness) {
                "mild" -> 5
                else -> 0
            }
        }
}