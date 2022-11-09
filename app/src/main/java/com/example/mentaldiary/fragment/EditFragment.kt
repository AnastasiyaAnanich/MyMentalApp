package com.example.mentaldiary.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.mentaldiary.base.BaseFragment
import com.example.mentaldiary.databinding.FragmentEditBinding


class EditFragment : BaseFragment<FragmentEditBinding>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEditBinding = FragmentEditBinding.inflate(inflater, container, false)


    override fun FragmentEditBinding.onBindView(saveInstanceState: Bundle?) {
        notesButtonHome.setOnClickListener {
            navController.navigate(EditFragmentDirections.actionDiaryFragmentToHomeFragment())
        }
        diaryButtonSave.setOnClickListener {
            Toast.makeText(requireContext(), "сохранено", Toast.LENGTH_SHORT)
                .show()
        }
    }
}