package com.example.toyproject_dpm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toyproject_dpm.model.UserModel
import com.example.toyproject_dpm.phonebook.UserAdapter
import kotlinx.android.synthetic.main.fragment_phone_book_fragment.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


}