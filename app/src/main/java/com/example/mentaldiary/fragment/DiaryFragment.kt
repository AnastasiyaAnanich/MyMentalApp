package com.example.mentaldiary.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mentaldiary.databinding.FragmentDiaryBinding
import com.example.mentaldiary.list.DiaryRecyclerAdapter
import com.example.mentaldiary.fragment.base.BaseFragment
import com.example.mentaldiary.ui.viewModels.DiaryViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DiaryFragment : BaseFragment<FragmentDiaryBinding>() {

    private lateinit var diaryRecycler: RecyclerView
    private lateinit var addDiary: FloatingActionButton
    private lateinit var adapter: DiaryRecyclerAdapter
    lateinit var viewModel: DiaryViewModel

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDiaryBinding = FragmentDiaryBinding.inflate(inflater, container, false)


    override fun FragmentDiaryBinding.onBindView(saveInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(context)
        diaryRecycler = diaryRecyclerView
        diaryRecycler.layoutManager = layoutManager
        //adapter = DiaryRecyclerAdapter()
        addDiary = buttonAddDiary


    }
}


