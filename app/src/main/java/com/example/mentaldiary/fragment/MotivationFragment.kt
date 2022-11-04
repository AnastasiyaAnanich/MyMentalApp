package com.example.mentaldiary.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mentaldiary.databinding.FragmentMotivationBinding
import com.example.mentaldiary.fragment.base.BaseFragment
import com.example.mentaldiary.fragment.motivation.MotivationViewModel


class MotivationFragment : BaseFragment<FragmentMotivationBinding>() {
    lateinit var viewModel: MotivationViewModel

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMotivationBinding = FragmentMotivationBinding.inflate(inflater, container, false)


    override fun FragmentMotivationBinding.onBindView(saveInstanceState: Bundle?) {
        motivationBookButton.setOnClickListener {
            viewModel.getBook(4)
        }
        viewModel.bookLiveData.observe(viewLifecycleOwner) { book ->
            println(book.toString())
        }
    }
}
