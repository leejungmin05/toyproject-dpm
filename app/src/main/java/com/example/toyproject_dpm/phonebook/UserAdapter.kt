package com.example.toyproject_dpm.phonebook

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.toyproject_dpm.R
import com.example.toyproject_dpm.model.UserModel
import kotlinx.android.synthetic.main.item_phonebook_user.view.*

class UserAdapter(
        var userData: MutableList<UserModel> = mutableListOf()  //json 파일...?

) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_phonebook_user,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.bind(userData[position])
        Log.d("리사이클러뷰","리사이클러뷰")
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val userNameTextView: TextView = view.userName
        private val userAgeTextView: TextView = view.userAge
        private val userPhoneNumTextView: TextView = view.userPhoneNum
        private val userNativeTextView: TextView = view.userCountry
        private val userProfileImageView: ImageView = view.userProfile

        fun bind(userModel: UserModel) {
            userNameTextView.text = userModel.Name
            //ToDo ("살" string인자로 넣기)
            userAgeTextView.text = userModel.age.toString() +"살"
            userPhoneNumTextView.text = userModel.PhoneNum
            userNativeTextView.text = userModel.Country
            userProfileImageView.setImageResource(R.drawable.simple0)

        }

    }

}



