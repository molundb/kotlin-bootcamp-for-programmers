fun main(args: Array<String>) {
    var fortuneCookie = getFortune(getBirthday())
    println("Your fortune is: $fortuneCookie")
    while(!fortuneCookie.startsWith("Take it easy")) {
        fortuneCookie = getFortune(getBirthday())
        println("Your fortune is: $fortuneCookie")
    }
}

fun getFortune(birthday : Int) : String {
    val fortunes = listOf ("You will have a great day!", "Things will go well for you today.", "Enjoy a wonderful day of success.", "Be humble and all will turn out well.", "Today is good day for exercising restraint.", "Take it easy and enjoy life!", "Treasure your friends because they are your greatest fortune.")
    return when(birthday) {
        in 1..7 -> fortunes[0]
        28, 31 -> fortunes[1]
        else -> fortunes[birthday.rem(fortunes.size)]
    }
}

fun getBirthday(): Int {
    print("\nPlease enter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}