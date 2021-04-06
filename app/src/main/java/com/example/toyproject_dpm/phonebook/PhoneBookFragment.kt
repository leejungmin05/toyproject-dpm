package com.example.toyproject_dpm.phonebook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toyproject_dpm.R
import com.example.toyproject_dpm.model.UserModel
import com.google.gson.Gson
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userDTOList = getJSONFromAssets()
        val userAdapter = UserAdapter(userDTOList, this)
        try {
            val users = Gson().fromJson(getJSONFromAssets(), UserModel::class.java)

            PBrcv.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL, false)
            //val itemAdapter = UserAdapter(context, users.Users)
            PBrcv.adapter = userAdapter
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