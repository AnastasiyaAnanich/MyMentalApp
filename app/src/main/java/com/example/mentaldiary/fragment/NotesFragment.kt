package com.example.mentaldiary.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mentaldiary.databinding.FragmentNotesBinding
import com.example.mentaldiary.base.BaseFragment


class NotesFragment : BaseFragment<FragmentNotesBinding>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotesBinding = FragmentNotesBinding.inflate(inflater, container, false)


    override fun FragmentNotesBinding.onBindView(saveInstanceState: Bundle?) {
        diaryButtonHomeDiary.setOnClickListener {
            navController.navigate(NotesFragmentDirections.actionDiaryFragmentToHomeFragment())
        }
    }
}