package com.example.toyproject_dpm.phonebook


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toyproject_dpm.R
import com.example.toyproject_dpm.databinding.FragmentPhoneBookFragmentBinding
import com.example.toyproject_dpm.model.UserModel
import com.google.gson.Gson
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset


class PhoneBookFragment : Fragment() {
    private lateinit var mbinding: FragmentPhoneBookFragmentBinding

    private fun getJSONFromAssets(): MutableList<UserModel> {
        val json: String?
        val gson = Gson()
        val userData: MutableList<UserModel> = mutableListOf()
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile = resources.assets.open("Sample_List.json")
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer, charset)

            val jObject = JSONObject(json)
            val jArray = jObject.getJSONArray("data")

            for (i in 0 until jArray.length()) {
                val data = gson.fromJson(jArray.get(i).toString(), UserModel::class.java)
                userData.add(data)
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return userData
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mbinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_phone_book_fragment,
            container,
            false
        )

        val userAdapter = UserAdapter()
        userAdapter.userData = getJSONFromAssets()
        mbinding.PBrcv.adapter = userAdapter
        mbinding.PBrcv.layoutManager = LinearLayoutManager(this.context)
        val decoration = DividerItemDecoration(
            mbinding.PBrcv.context,
            LinearLayoutManager(this.context).orientation
        )
        mbinding.PBrcv.addItemDecoration(decoration)


        return mbinding.root
    }


}