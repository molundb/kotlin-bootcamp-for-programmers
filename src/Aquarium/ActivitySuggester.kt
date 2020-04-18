fun main(args: Array<String>) {
    val mood = getMoodFromUser()
    whatShouldIDoToday(mood!!)
}

fun getMoodFromUser(): String? {
    print("What is your current mood? ")
    return readLine()
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24) {
    val activity = when {
        isHappyAndSunny(mood, weather) -> "Go for a walk"
        isHappyAndWarm(mood, temperature) -> "Go to the beach"
        isTired(mood) -> "Go to sleep"
        isGreat(mood, weather) -> "Go on a trip"
        else -> "Stay home and read."
    }

    println(activity)
}

private fun isGreat(mood: String, weather: String) = mood == "great" && weather == "great"

private fun isTired(mood: String) = mood == "tired"

private fun isHappyAndWarm(mood: String, temperature: Int) = mood == "happy" && temperature > 20

private fun isHappyAndSunny(mood: String, weather: String) = mood == "happy" && weather == "sunny"