package com.example.toyproject_dpm.phonebook

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.toyproject_dpm.R
import com.example.toyproject_dpm.databinding.ItemPhonebookUserBinding
import com.example.toyproject_dpm.model.UserModel
import kotlinx.android.synthetic.main.item_phonebook_user.view.*

class UserAdapter(
        var userData: MutableList<UserModel> = mutableListOf()
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private lateinit var mbinding: ItemPhonebookUserBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mbinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_phonebook_user,
            parent,
            false
        )
        return ViewHolder(mbinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userData[position])
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    class ViewHolder(private val binding: ItemPhonebookUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // private val userProfileImageView: ImageView = binding.userProfile
        //var profileImages: IntArray = intArrayOf(R.drawable.simple0,R.drawable.simple1,R.drawable.simple2,R.drawable.simple3,R.drawable.simple4,R.drawable.simple5,R.drawable.simple6,R.drawable.simple7,R.drawable.simple8)

        fun bind(userData: UserModel) {

                binding.userModel = userData
                binding.executePendingBindings()
                //binding.userProfile.setImageDrawable(userData.image)
                //val random = (Math.random() * profileImages.size).toInt()
                //userProfileImageView.setImageResource(profileImages[random])


        }


    }
}



