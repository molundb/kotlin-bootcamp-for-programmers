package Aquarium

import src.Aquarium.FishAction
import src.Aquarium.Plecostomus
import src.Aquarium.Shark

fun main(args: Array<String>) {
    buildAquarium()
    makeSpices()
    makeFish()
}

fun buildAquarium() {

    val myAquarium = Aquarium()

    println(
        "Length: ${myAquarium.length} " +
                "Width: ${myAquarium.width} " +
                "Height: ${myAquarium.height}"
    )

    myAquarium.height = 80

    println("Height: ${myAquarium.height}")

    println("Volume: ${myAquarium.volume} liters")

    val smallAquarium = Aquarium(length = 20, width = 15, height = 30)
    println("Small Aquarium: ${smallAquarium.volume} liters")

    val myAquarium2 = Aquarium(numberOfFish = 9)

    println(
        "Small Aquarium 2: ${myAquarium2.volume} liters with " +
                "legnth ${myAquarium2.length} " +
                "width ${myAquarium2.width} " +
                "height ${myAquarium2.height} "
    )
}

fun makeSpices() {
    val spice = SimpleSpice()

    println(spice.name)
    println(spice.heat)
}

fun feedFish(fish: FishAction) {
    // make some food then
    fish.eat()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println ("Shark: ${shark.color} \nPlecostomus: ${pleco.color}")

    shark.eat()
    pleco.eat()
}