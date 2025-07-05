package com.example.addressbookapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofitclient
{
val retrofit=Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    val service= retrofit.create(UserInterface::class.java)
}