package src.Aquarium2

import kotlin.random.Random

const val MAXIMUM_NUMBER_OF_BORROWED_BOOKS = 3

fun main(args: Array<String>) {
    val book = Book("Titel", "Martin", 2010, 128)

    println("Here is your book ${book.getTitleAuthor().first} written by ${book.getTitleAuthor().second} in ${book.getTitleAuthorYear().third}")

    val allBooks = setOf(
       "title1",
        "title2",
        "title3"
    )

    val library = mapOf(
        "William Shakespeare" to allBooks
    )

    library.any { it.value.contains("Hamlet")}

    val moreBooks = mutableMapOf(
        "Harry Potter" to "JK Rowling"
    )

    moreBooks.getOrPut("Hamlet", {"William Shakespeare"})

    val puppy = Puppy()

    while (book.pages > 0) {
        println(book.pages)
        puppy.playWithBook(book)
    }
}

class Book(
    private val title: String,
    private val author: String,
    private val year: Int,
    var pages: Int
) {

    companion object {
        const val BASE_URL = "www.books.com"
    }

    fun getTitleAuthor() = title to author
    fun getTitleAuthorYear() = Triple(title, author, year)

    fun canBorrow() = MAXIMUM_NUMBER_OF_BORROWED_BOOKS

    fun printUrl() = println("$BASE_URL$title.html")
}

fun Book.getWeight() : Double { return (pages * 1.5) }
fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

class Puppy() {
    fun playWithBook(book: Book) {
        book.tornPages((Random.nextInt(12)))
    }
}