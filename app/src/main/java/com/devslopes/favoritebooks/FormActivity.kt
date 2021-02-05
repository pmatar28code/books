package com.devslopes.favoritebooks

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devslopes.favoritebooks.databinding.ActivityFormBinding
import com.devslopes.favoritebooks.models.Book
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.activity_main.*


class FormActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fBook = Book(
                title = form_title.toString(),
                author = form_author.toString(),
                genre = form_genre.toString(),
                length = form_length.toString()
        )

        form_button.setOnClickListener {  BookRepository.addBook(fBook,this)

            val intent = Intent(this,MainActivity::class.java)
            button_to_form.setOnClickListener { startActivity(intent) }}
    }
        //fun createBook() {
            //val formTitle = form_title.toString()
             //val formAuthor = form_author.toString()
            //val formGenre = form_genre.toString()
            //val formLength = form_length.toString()
            //var bookString: String = ""

           // bookString+= "$formTitle,$formAuthor,$formGenre,$formLength"
            //val newBook = Book.Companion.fromCsv(bookString)





        }







