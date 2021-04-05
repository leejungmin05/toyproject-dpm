package com.example.toyproject_dpm.phonebook

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toyproject_dpm.R
import com.example.toyproject_dpm.model.UserModel
import com.example.toyproject_dpm.model.Users
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_phone_book_fragment.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset


class PhoneBookFragment : Fragment() {
    private val recyclerAdapter: UserAdapter by lazy {
        UserAdapter()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_phone_book_fragment, container, false)

        return view
    }
    private fun userDTOList(): ArrayList<UserModel> {
        try {
            val users = Gson().fromJson(getJSONFromAssets(), UserModel::class.java)

//            PBrcv.layoutManager = LinearLayoutManager(this)
//            val itemAdapter = UserAdapter(this, users.Users)
//            PBrcv.adapter = itemAdapter
          } catch(e: JSONException) {
            e.printStackTrace()
            }
        }

    private fun getJSONFromAssets(): String? {
        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile =resources.assets.open("Sample_List.json")
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

}