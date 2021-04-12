package com.example.toyproject_dpm.model

data class Users (
        val users: ArrayList<UserModel>
        )
data class UserModel(
        val Name: String,
        val PhoneNum: String,
        val age: Int,
        val Country: String

)
