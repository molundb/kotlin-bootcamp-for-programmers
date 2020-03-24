package src.Aquarium

fun main(args: Array<String>) {
    val book = Book("Titel", "Martin", 2010)

    println("Here is your book ${book.getTitleAuthor().first} written by ${book.getTitleAuthor().second} in ${book.getTitleAuthorYear().third}")
}

class Book(private val title: String, private val author: String, private val year: Int) {

    fun getTitleAuthor() = title to author
    fun getTitleAuthorYear() = Triple(title, author, year)
}
