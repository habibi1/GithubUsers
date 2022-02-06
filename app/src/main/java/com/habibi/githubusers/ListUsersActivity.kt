package com.habibi.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.habibi.githubusers.databinding.ActivityListUsersBinding

class ListUsersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}