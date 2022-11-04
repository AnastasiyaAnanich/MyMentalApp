package com.example.mentaldiary.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mentaldiary.fragment.base.BaseFragment
import com.example.mentaldiary.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {


    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)


    override fun FragmentHomeBinding.onBindView(saveInstanceState: Bundle?) {
        practiceButton.setOnClickListener {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToPracticeFragment2())
        }
        diaryButton.setOnClickListener {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToDiaryFragment2())
        }
        motivationButton.setOnClickListener {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToMotivationFragment2())

        }
    }
}