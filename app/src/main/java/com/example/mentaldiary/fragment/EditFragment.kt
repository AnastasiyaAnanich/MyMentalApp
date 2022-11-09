package com.example.mentaldiary.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mentaldiary.base.BaseFragment
import com.example.mentaldiary.databinding.FragmentNoteBinding


class EditFragment : BaseFragment<FragmentNoteBinding>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNoteBinding = FragmentNoteBinding.inflate(inflater, container, false)


    override fun FragmentNoteBinding.onBindView(saveInstanceState: Bundle?) {
        notesButtonHome.setOnClickListener {
            navController.navigate(EditFragmentDirections.actionDiaryFragmentToHomeFragment())
        }
    }
}