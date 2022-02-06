package com.habibi.githubusers.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.habibi.githubusers.databinding.ItemListUserBinding
import com.habibi.githubusers.model.User

class ListUsersAdapter(
    private val list: List<User>,
    private val onClick: (User) -> Unit
) : RecyclerView.Adapter<ListUsersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemListUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(
        private val binding: ItemListUserBinding,
        private val onClick: (User) -> Unit
    ): RecyclerView.ViewHolder(binding.root){

        private var currentItem: User? = null

        init {
            binding.root.setOnClickListener {
                currentItem?.let {
                    onClick(it)
                }
            }
        }

        fun bind(user: User){
            currentItem = user

            binding.apply {
                ivAvatar.setImageResource(user.avatar)
                tvName.text = user.username
                tvType.text = user.company
            }
        }
    }
}