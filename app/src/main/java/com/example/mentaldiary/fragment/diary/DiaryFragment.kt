package com.example.mentaldiary.fragment.diary

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mentaldiary.databinding.FragmentDiaryBinding
import com.example.mentaldiary.fragment.base.BaseFragment
import com.example.mentaldiary.list.DiaryRecyclerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class DiaryFragment : BaseFragment<FragmentDiaryBinding>(), DiaryRecyclerAdapter.DiaryClick,
    DiaryRecyclerAdapter.DiaryClickDelete {
    lateinit var diaryRecycler: RecyclerView
    lateinit var addDiary: FloatingActionButton
    lateinit var diaryRVAdapter: DiaryRecyclerAdapter

    private val viewModel by viewModel<DiaryViewModel>()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDiaryBinding = FragmentDiaryBinding.inflate(inflater, container, false)


    override fun FragmentDiaryBinding.onBindView(saveInstanceState: Bundle?) {
        diaryRecycler = diaryRecyclerView
        addDiary = buttonAddDiary
        diaryRecycler.layoutManager = LinearLayoutManager(requireContext())
        val diaryRecyclerAdapter =
            DiaryRecyclerAdapter(requireContext(), this@DiaryFragment, this@DiaryFragment)
        diaryRecycler.adapter = diaryRecyclerAdapter
        viewModel.updateDiary(Diary("", "", ""))
        viewModel.allDiary.observe(viewLifecycleOwner) { diary ->
            diaryRVAdapter.updateList(diary)
        }
        diaryRecycler.adapter = diaryRVAdapter

        addDiary.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, EditDiaryFragment::class.java))
                finish()
            }
        }
    }


    override fun onDeleteIconClick(diary: Diary) {
        viewModel.deleteDiary(diary)
        Toast.makeText(requireContext(), "${diary.diaryTittle} Deleted", Toast.LENGTH_LONG).show()

    }


    override fun onClick(diary: Diary) {
        requireActivity().run {
            startActivity(Intent(this, EditDiaryFragment::class.java))
            intent.putExtra("diaryType", "Edit")
            intent.putExtra("diaryTittle", diary.diaryTittle)
            intent.putExtra("diaryDescription", diary.diaryDescription)
            intent.putExtra("diaryId", diary.id)
            startActivity(intent)
            this.finish()
        }
    }
}






