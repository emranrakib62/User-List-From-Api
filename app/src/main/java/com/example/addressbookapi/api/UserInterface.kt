package com.example.addressbookapi.api

import com.example.addressbookapi.datamodel.User
import retrofit2.Call
import retrofit2.http.GET

interface UserInterface {

    @GET("users")
    fun getAllUsers():Call <List<User>>
}