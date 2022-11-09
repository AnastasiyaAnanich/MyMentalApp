package com.example.mentaldiary.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mentaldiary.R
import com.example.mentaldiary.fragment.practice.Meditation

class MedAdapter(private val meditationList: ArrayList<Meditation>) :
    RecyclerView.Adapter<MedAdapter.MeditationVHolder>() {

    class MeditationVHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.list_noticeImage)
        val text: TextView = itemView.findViewById(R.id.list_noteTitleOne)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeditationVHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_practice, parent, false)
        return MeditationVHolder(itemView)
    }

    override fun onBindViewHolder(holder: MeditationVHolder, position: Int) {
        val currentItem = (meditationList[position])
        holder.image.setImageResource(currentItem.tittleImage)
        holder.text.text = currentItem.headingText

    }

    override fun getItemCount(): Int {
        return meditationList.size
    }
}