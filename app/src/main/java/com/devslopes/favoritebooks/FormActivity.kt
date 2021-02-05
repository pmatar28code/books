package com.devslopes.favoritebooks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devslopes.favoritebooks.databinding.ActivityFormBinding
import com.devslopes.favoritebooks.databinding.ActivityMainBinding
import com.devslopes.favoritebooks.models.Book
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        form_button.setOnClickListener { createBook() }
    }
        fun createBook() {
            val formTitle = form_title.toString()
            val formAuthor = form_author.toString()
            val formGenre = form_genre.toString()
            val formLength = form_length.toString()
            var bookString: String = ""

            bookString+= "$formTitle,$formAuthor,$formGenre,$formLength"
            val newBook = Book.Companion.fromCsv(bookString)

            BookRepository.addBook(newBook,this)


        }

}