package com.example.mentaldiary.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mentaldiary.list.MedAdapter
import com.example.mentaldiary.R
import com.example.mentaldiary.databinding.FragmentPracticeBinding
import com.example.mentaldiary.fragment.base.BaseFragment
import com.example.mentaldiary.fragment.practice.Meditation


class PracticeFragment : BaseFragment<FragmentPracticeBinding>() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var meditationArrayList: ArrayList<Meditation>
    private lateinit var adapter: MedAdapter

    private lateinit var imageId: Array<Int>
    private lateinit var headingText: Array<String>

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPracticeBinding = FragmentPracticeBinding.inflate(inflater, container, false)


    override fun FragmentPracticeBinding.onBindView(saveInstanceState: Bundle?) {
        diaryButtonHomePractice.setOnClickListener {
            navController.navigate(PracticeFragmentDirections.actionPracticeFragmentToHomeFragment())
        }

        initData()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = recyclerViewPractice
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
            getString(R.string.head3),
            getString(R.string.head4)
        )

        for (i in imageId.indices) {
            val med = Meditation(imageId[i], headingText[i])
            meditationArrayList.add(med)

        }
    }
}
