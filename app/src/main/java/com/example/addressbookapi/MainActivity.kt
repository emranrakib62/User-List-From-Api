package com.example.addressbookapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.addressbookapi.api.Retrofitclient
import com.example.addressbookapi.datamodel.User
import com.example.addressbookapi.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.userRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchUsers()
    }

    private fun fetchUsers() {
        val call = Retrofitclient.service.getAllUsers()
        call.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("MainActivity", "Error: ${t.message}")
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val userList = response.body()
                    userList?.let {
                        adapter = UserAdapter(it)
                        recyclerView.adapter = adapter
                    }
                } else {
                    Log.e("MainActivity", "Failed with code: ${response.code()}")
                }
            }
        })
    }
}
