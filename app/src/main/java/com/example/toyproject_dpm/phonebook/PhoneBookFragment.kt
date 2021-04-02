package com.example.toyproject_dpm.phonebook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.toyproject_dpm.R
import com.example.toyproject_dpm.model.UserModel
import com.google.gson.Gson


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
        return inflater.inflate(R.layout.fragment_phone_book_fragment, container, false)
    }

//    fun parseJson(): List<UserModel> {
//        val gson = Gson()
//        val testString: String =gson.toJson(UserModel)
//
//
//         gson.fromJson(testString, Array<UserModel>::class.java)
//    }


}