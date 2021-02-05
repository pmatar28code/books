package com.devslopes.favoritebooks

import android.content.Intent
import android.os.Bundle
import android.util.Log
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



        form_button.setOnClickListener {
            val fBook = Book(
                    title =  binding.titleEdit.text.toString(),
                    author = binding.authorEdit.text.toString(),
                    genre =  binding.genreEdit.text.toString(),
                    length = binding.lenghtEdit.text.toString()

            )
            Log.v("object created book","book: $fBook")
            BookRepository.addBook(fBook,this)
            //Log.v("add book from form","add bool: ${BookRepository.addBook(fBook,this)}")
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
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







