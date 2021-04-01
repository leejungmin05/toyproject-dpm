package com.example.toyproject_dpm.phonebook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toyproject_dpm.R
import com.google.gson.Gson
import java.io.FileNotFoundException


class PhoneBookFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
       // UserList.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phone_book_fragement, container, false)
    }

//    fun parseJson(): List<UserDTO> {
//        val gson = Gson()
//        val testString: String
//
//        try{
//            testString = applicationContext.assets.open("Sample_List.json").bufferedReader().use{it.readText()}
//        }catch (e: FileNotFoundException) {
//            e.printStackTrace()
//            return emptyList()
//        }
//
//        return gson.fromJson(testString, Array<UserDTO>::class.java).toList()
//    }


}