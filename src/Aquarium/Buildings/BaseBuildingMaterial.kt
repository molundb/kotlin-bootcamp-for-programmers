package src.Aquarium.Buildings

fun main(args: Array<String>) {
    val woodBuilding = Building(Wood())
    woodBuilding.build()
    woodBuilding.isSmallBuilding(Building(Brick()))
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

class Building<T: BaseBuildingMaterial>(private val buildingMaterial: T) {

    private val baseMaterialsNeeded = 100
    private val actualMaterialsNeeded = baseMaterialsNeeded * buildingMaterial.numberNeeded

    fun build() {
        println("We need $actualMaterialsNeeded ${buildingMaterial::class.simpleName}")
    }

    fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
        if (building.actualMaterialsNeeded < 500) println("small building")
        else println("large building")
    }
}