package com.devslopes.favoritebooks

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.devslopes.favoritebooks.databinding.ActivityMainBinding
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
                             var booksListFromRepo = BookRepository.getListOfBooks().toMutableList()
                            // booksListFromRepo.removeAt(position)
                             BookRepository.removeBook(booksListFromRepo[position],this@MainActivity)

                            // a way to refresh mainActivity, to get recycler view show changes
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
        //only when scrollong down

        /*book_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && button_to_form.getVisibility() === View.VISIBLE) {
                    button_to_form.hide()
                } else if (dy < 0 && button_to_form.getVisibility() !== View.VISIBLE) {
                    button_to_form.show()
                }
            }
        })*/

        book_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                when (newState) {
                    RecyclerView.SCROLL_STATE_IDLE -> button_to_form.show()
                    else -> button_to_form.hide()
                }
                super.onScrollStateChanged(recyclerView, newState)
            }
        })

            val intent = Intent(this@MainActivity,FormActivity::class.java)
            button_to_form.setOnClickListener { startActivity(intent) }


        }

    }







