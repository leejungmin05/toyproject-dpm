package com.example.toyproject_dpm.model

import android.graphics.drawable.Drawable

data class Users (
        val users: ArrayList<UserModel>
        )
data class UserModel(
        val image: Drawable,
        val Name: String,
        val PhoneNum: String,
        val age: Int,
        val Country: String

)
