package com.devslopes.favoritebooks

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.devslopes.favoritebooks.databinding.ActivityMainBinding
import com.devslopes.favoritebooks.databinding.ItemBookBinding
import com.devslopes.favoritebooks.models.Book
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bookList.apply {
            adapter = BooksAdapter(BookRepository.getBooks(this@MainActivity))

            val mIth = ItemTouchHelper(
                    object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT
                            ) {
                        override fun onMove(recyclerView: RecyclerView,
                                                     viewHolder: ViewHolder, target: ViewHolder): Boolean {
                            val fromPos = viewHolder.adapterPosition
                            val toPos = target.adapterPosition
                            // move item in `fromPos` to `toPos` in adapter.
                            return true // true if moved, false otherwise
                        }

                        override fun onSwiped(viewHolder: ViewHolder, direction: Int ) {
                            // remove from adapter

                             var position: Int = viewHolder.adapterPosition
                             var booksListFromRepo = BookRepository.getListOfBooks()
                            // booksListFromRepo.removeAt(position)
                             BookRepository.removeBook(booksListFromRepo[position],this@MainActivity)

                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(getIntent());
                            overridePendingTransition(0, 0);


                        }

                    })

                        mIth.attachToRecyclerView(this)


            layoutManager = LinearLayoutManager(this@MainActivity,
                    LinearLayoutManager.VERTICAL,
            false)


            }


        

            val intent = Intent(this@MainActivity,FormActivity::class.java)
            button_to_form.setOnClickListener { startActivity(intent) }


        }

    }







