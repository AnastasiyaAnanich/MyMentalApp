package com.example.mentaldiary.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.domain.models.BookDto
import com.example.mentaldiary.base.BaseViewHolder
import com.example.mentaldiary.databinding.ListItemMotivationBinding

class BookAdapter :
    ListAdapter<Any, BaseViewHolder<ViewBinding, Any>>(object : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean = when {
            oldItem is BookDto && newItem is BookDto -> oldItem.id == newItem.id
            else -> false
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean = when {
            oldItem is BookDto && newItem is BookDto -> oldItem == newItem
            else -> false
        }

    }) {

    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is BookDto -> LIST_ITEM_MOTIVATION_TYPE
        else -> throw java.lang.IllegalArgumentException(
            "Book Adapter can't handle item" + getItem(
                position
            )
        )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ViewBinding, Any> = when (viewType) {
        LIST_ITEM_MOTIVATION_TYPE -> BookViewHolder(parent) as BaseViewHolder<ViewBinding, Any>
        else -> throw java.lang.IllegalArgumentException("BookAdapter can't handle the $viewType type")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewBinding, Any>, position: Int) =
        holder.handleItem(getItem(position))

    companion object {
        private const val LIST_ITEM_MOTIVATION_TYPE = 997
    }
}

private class BookViewHolder(private val parent: ViewGroup) :
    BaseViewHolder<ListItemMotivationBinding, BookDto>(
        ListItemMotivationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    ) {
    override fun ListItemMotivationBinding.bind(value: BookDto) {
        authorBook.text = "Author: " + value.author
        tittleBook.text = "Tittle: " + value.tittle
        genreBook.text = "Genre: " + value.genre

        Glide.with(parent.context)
            .load(value.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(imageBook)
    }
}