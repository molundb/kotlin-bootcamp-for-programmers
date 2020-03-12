package Aquarium

fun main (args: Array<String>) {
    buildAquarium()
}

fun buildAquarium() {

    val myAquarium = Aquarium()

    println("Length: ${myAquarium.length} " +
            "Width: ${myAquarium.width} " +
            "Height: ${myAquarium.height}")

    myAquarium.height = 80

    println("Height: ${myAquarium.height}")

    println("Volume: ${myAquarium.volume} liters")

    val spice = SimpleSpice()

    println(spice.name)
    println(spice.heat)
}