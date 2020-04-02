package src.Aquarium.Buildings

fun main(args: Array<String>) {
    val woodBuilding = Building(Wood())
    woodBuilding.build()
}

open class BaseBuildingMaterial {
    open val numberNeeded: Int = 1
}

class Wood : BaseBuildingMaterial() {
    override val numberNeeded: Int = 4
}

class Brick : BaseBuildingMaterial() {
    override val numberNeeded: Int = 8
}

class Building<T: BaseBuildingMaterial>(val buildingMaterial: T) {

    val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = baseMaterialsNeeded * buildingMaterial.numberNeeded

    fun build() {
        println("We need ${actualMaterialsNeeded} ${buildingMaterial::class.simpleName}")
    }
}