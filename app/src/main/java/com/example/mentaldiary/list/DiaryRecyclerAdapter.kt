package com.example.mentaldiary.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mentaldiary.R
import com.example.mentaldiary.fragment.diary.Diary

class DiaryRecyclerAdapter(
    private val context: Context,
    private val diaryClickInterface: DiaryClick,
    private val diaryClickDeleteInterface: DiaryClickDelete
) : RecyclerView.Adapter<DiaryRecyclerAdapter.ViewHolder>() {

    private val allDiary = ArrayList<Diary>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val diaryHead = itemView.findViewById<TextView>(R.id.diary_text_head)!!
        val diaryDelete = itemView.findViewById<ImageView>(R.id.diary_Delete_remote)!!
        val diaryEdit = itemView.findViewById<TextView>(R.id.diary_editTime)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_diary,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.diaryHead.text = (allDiary[position].diaryTittle)
        holder.diaryEdit.text = (allDiary[position].diaryTimeStamp)

        holder.diaryDelete.setOnClickListener {
            diaryClickDeleteInterface.onDeleteIconClick(allDiary[position])
        }
        holder.itemView.setOnClickListener {
            diaryClickInterface.onClick(allDiary[position])
        }
    }


    override fun getItemCount(): Int {
        return allDiary.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Diary>) {
        allDiary.clear()
        allDiary.addAll(newList)
        notifyDataSetChanged()
    }

    interface DiaryClickDelete {
        fun onDeleteIconClick(diary: Diary)
    }

    interface DiaryClick {
        fun onClick(diary: Diary)
    }
}

