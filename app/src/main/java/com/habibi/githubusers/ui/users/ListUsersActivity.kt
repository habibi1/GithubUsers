package com.habibi.githubusers.ui.users

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.habibi.githubusers.R
import com.habibi.githubusers.databinding.ActivityListUsersBinding
import com.habibi.githubusers.model.User

class ListUsersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showRecyclerList(listUsers)
    }

    private val listUsers: ArrayList<User>
        @SuppressLint("Recycle")
        get() {
            val dataUsername = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getIntArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getIntArray(R.array.followers)
            val dataFollowing = resources.getIntArray(R.array.following)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val listUser = ArrayList<User>()
            for (i in dataUsername.indices) {
                val user = User(dataUsername[i],dataName[i], dataLocation[i], dataRepository[i], dataCompany[i], dataFollowers[i], dataFollowing[i], dataAvatar.getResourceId(i, -1))
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList(list: List<User>) {
        binding.rvListUsers.layoutManager = if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                GridLayoutManager(this, 2)
            } else {
                LinearLayoutManager(this)
            }

        val listUsersAdapter = ListUsersAdapter(list){

        }

        binding.rvListUsers.adapter = listUsersAdapter
    }
}