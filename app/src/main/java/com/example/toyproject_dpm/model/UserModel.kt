package com.example.toyproject_dpm.model

data class Users (
        val users: ArrayList<UserModel>
        )
data class UserModel(
        var Name: String,
        var PhoneNum: String,
        var age: Int,
        var Country: String

)
