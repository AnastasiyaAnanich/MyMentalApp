package com.example.mentaldiary.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mentaldiary.databinding.FragmentHomeBinding
import com.example.mentaldiary.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)


    override fun FragmentHomeBinding.onBindView(saveInstanceState: Bundle?) {
    imageImage.setOnClickListener {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToMotivationFragment2())
        }
        noticeImage.setOnClickListener {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToDiaryFragment2())
        }
        practiceImage.setOnClickListener {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToPracticeFragment2())
        }
    }
}