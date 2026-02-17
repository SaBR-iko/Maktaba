package com.ElOuedUniv.maktaba.data.repository

import androidx.lifecycle.viewmodel.CreationExtras
import com.ElOuedUniv.maktaba.data.model.Book

/**
 * Repository for managing book data
 * This follows the Repository pattern to abstract data sources
 */
class BookRepository {

    private val booksList = listOf(
        Book(isbn = "11111", title = "Clean Code", nbPages = 10),
        Book(isbn = "", title = "The Pragmatic Programmer", nbPages = 0),
        Book(isbn = "", title = "Design Patterns", nbPages = 0),
        Book(isbn = "", title = "Refactoring", nbPages = 0),
        Book(isbn = "", title = "Head First Design Patterns", nbPages = 0)
    )
//    private val booksList = listOf<Book>()
    fun getAllBooks(): List<Book> {
        return booksList
    }

    fun getBookByIsbn(isbn: String): Book? {
        return booksList.find { it.isbn == isbn }
    }
}
