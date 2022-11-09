package com.example.mentaldiary.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.mentaldiary.base.BaseFragment
import com.example.mentaldiary.databinding.FragmentHomeBinding

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
        emotionOne.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "что,бы поднять себе настроение можно заняться спортом",
                Toast.LENGTH_SHORT
            ).show()
        }
        emotionTwo.setOnClickListener {
            Toast.makeText(requireContext(), "мы рады , что у вас всё хорошо", Toast.LENGTH_SHORT)
                .show()
        }
        emotionThree.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Отлично!Продолжайте в том же духе",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}


