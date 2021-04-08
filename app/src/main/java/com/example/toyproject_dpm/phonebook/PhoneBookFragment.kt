package com.example.toyproject_dpm.phonebook


import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toyproject_dpm.R
import com.example.toyproject_dpm.model.UserModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_phone_book_fragment.*
import kotlinx.android.synthetic.main.fragment_phone_book_fragment.view.*
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset



class PhoneBookFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view =
            inflater.inflate(R.layout.fragment_phone_book_fragment, container, false)
        val decoration = DividerItemDecoration(context,VERTICAL)
        PBrcv.addItemDecoration(decoration)

        val userAdapter = UserAdapter()
        view.PBrcv.adapter = UserAdapter()
        view.PBrcv.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL, false)
        userAdapter.userData =  getJSONFromAssets()

        return view
    }

    private fun getJSONFromAssets(): MutableList<UserModel>{
        val json: String?
        val gson = Gson()
        val userData: MutableList<UserModel> = mutableListOf()
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile =resources.assets.open("Sample_List.json")
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer, charset)

            val jObject = JSONObject(json)
            val jArray = jObject.getJSONArray("data")

            for(i in 0 until jArray.length()){
                val contactObj = gson.fromJson(jArray.get(i).toString(), UserModel::class.java)
                userData.add(contactObj)
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return userData
    }


}