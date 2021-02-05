package com.devslopes.favoritebooks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.devslopes.favoritebooks.databinding.ActivityMainBinding
import com.devslopes.favoritebooks.models.Book
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bookList.apply {
            adapter = BooksAdapter(BookRepository.getBooks(this@MainActivity)
            )/*{bookModel ->
                val intent = Intent(this@MainActivity,BookRepository::class.java)
                intent.putExtra(BookRepository.CATEGORY,categoryModel.title)
                startActivity(intent)
            }
*/
            layoutManager = LinearLayoutManager(this@MainActivity)

            }


        val intent = Intent(this@MainActivity,FormActivity::class.java)
        button_to_form.setOnClickListener { startActivity(intent) }
        }



    }



