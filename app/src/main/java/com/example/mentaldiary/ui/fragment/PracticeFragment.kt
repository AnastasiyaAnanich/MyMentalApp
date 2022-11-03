package com.example.mentaldiary.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mentaldiary.R
import com.example.mentaldiary.practice.Meditation
import com.example.mentaldiary.ui.adapter.MedAdapter


class PracticeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var meditationArrayList: ArrayList<Meditation>
    private lateinit var adapter: MedAdapter

    private lateinit var imageId: Array<Int>
    private lateinit var headingText: Array<String>
    private lateinit var med: Array<String>

    @Override
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_practice, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.textView)


        initData()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_View_Practice)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MedAdapter(meditationArrayList)
        recyclerView.adapter = adapter

    }

    private fun initData() {
        meditationArrayList = arrayListOf()

        imageId = arrayOf(
            R.drawable.med3,
            R.drawable.med4,
            R.drawable.med5,
            R.drawable.med6
        )
        headingText = arrayOf(
            getString(R.string.head1),
            getString(R.string.head2),
            getString(R.string.head1),
            getString(R.string.head2)
        )
        med = arrayOf(
            getString(R.string.news1),
            getString(R.string.news2),
            getString(R.string.news1),
            getString(R.string.news2)
        )
        for (i in imageId.indices) {
            val med = Meditation(imageId[i], headingText[i])
            meditationArrayList.add(med)

        }
    }
}