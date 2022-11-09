package com.example.mentaldiary.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.domain.models.UserDto
import com.example.mentaldiary.base.BaseViewHolder
import com.example.mentaldiary.databinding.ListItemUserBinding


class UserAdapter :
    ListAdapter<Any, BaseViewHolder<ViewBinding, Any>>(object : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean = when {
            oldItem is UserDto && newItem is UserDto -> oldItem.id == newItem.id
            else -> false
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean = when {
            oldItem is UserDto && newItem is UserDto -> oldItem == newItem
            else -> false
        }
    }) {

    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is UserDto -> LIST_ITEM_MOTIVATION
        else -> throw java.lang.IllegalArgumentException(
            "UserAdapter can't handle item" + getItem(
                position
            )
        )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): BaseViewHolder<ViewBinding, Any> = when (viewType) {
        LIST_ITEM_MOTIVATION -> UserViewHolder(parent) as BaseViewHolder<ViewBinding, Any>
        else -> throw java.lang.IllegalArgumentException("UserAdapter can't handle the $viewType type")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewBinding, Any>, position: Int) =
        holder.handleItem(getItem(position))

    companion object {
        private const val LIST_ITEM_MOTIVATION = 997
    }
}

private class UserViewHolder(private val parent: ViewGroup) :
    BaseViewHolder<ListItemUserBinding, UserDto>(
        ListItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    ) {
    @SuppressLint("SetTextI18n")
    override fun ListItemUserBinding.bind(value: UserDto) {
        titleFirstName.text = "Имя: " + value.firstname
        titleLastName.text = "Фамилия: " + value.lastname

        Glide.with(parent.context)
            .load(value.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop().into(imageImage)
    }
}





























































