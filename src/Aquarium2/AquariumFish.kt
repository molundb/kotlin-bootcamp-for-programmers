package src.Aquarium2

abstract class AquairumFish {
    abstract val color: String
}

class Shark: AquairumFish(), FishAction {

    override val color = "gray"

    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus: AquairumFish(), FishAction {

    override val color = "gold"

    override fun eat() {
        println("munch on algae")
    }
}

interface FishAction {

    fun eat()
}