package com.devslopes.favoritebooks

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.devslopes.favoritebooks.databinding.ItemBookBinding

class BookActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ItemBookBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}