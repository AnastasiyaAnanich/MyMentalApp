package com.example.mentaldiary.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.domain.models.ImagesDto
import com.example.mentaldiary.base.BaseViewHolder
import com.example.mentaldiary.databinding.ListItemImagesBinding


class ImagesAdapter :
    ListAdapter<Any, BaseViewHolder<ViewBinding, Any>>(object : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean = when {
            oldItem is ImagesDto && newItem is ImagesDto -> oldItem.title == newItem.title
            else -> false
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean = when {
            oldItem is ImagesDto && newItem is ImagesDto -> oldItem == newItem
            else -> false
        }
    }) {

    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is ImagesDto -> LIST_ITEM_IMAGES
        else -> throw java.lang.IllegalArgumentException(
            "ImagesAdapter can't handle item" + getItem(
                position
            )
        )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): BaseViewHolder<ViewBinding, Any> = when (viewType) {
        LIST_ITEM_IMAGES -> ImagesViewHolder(parent) as BaseViewHolder<ViewBinding, Any>
        else -> throw java.lang.IllegalArgumentException("ImagesAdapter can't handle the $viewType type")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewBinding, Any>, position: Int) =
        holder.handleItem(getItem(position))

    companion object {
        private const val LIST_ITEM_IMAGES = 997
    }
}

private class ImagesViewHolder(private val parent: ViewGroup) :
    BaseViewHolder<ListItemImagesBinding, ImagesDto>(
        ListItemImagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    ) {
    @SuppressLint("SetTextI18n")
    override fun ListItemImagesBinding.bind(value: ImagesDto) {
        tittle.text = "Tittle: " + value.title
        description.text = "Description: " + value.description

        Glide.with(parent.context)
            .load(value.url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop().into(imageImage)
    }
}





























































