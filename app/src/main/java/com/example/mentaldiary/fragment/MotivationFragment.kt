package com.example.mentaldiary.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mentaldiary.databinding.FragmentMotivationBinding
import com.example.mentaldiary.fragment.base.BaseFragment
import com.example.mentaldiary.fragment.motivation.MotivationViewModel
import com.example.mentaldiary.list.BookAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class MotivationFragment : BaseFragment<FragmentMotivationBinding>() {
    private val viewModel by viewModel<MotivationViewModel>()

    private val bookAdapter = BookAdapter()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMotivationBinding = FragmentMotivationBinding.inflate(inflater, container, false)


    override fun FragmentMotivationBinding.onBindView(saveInstanceState: Bundle?) {
        diaryButtonHomeMotivation.setOnClickListener {
            navController.navigate(MotivationFragmentDirections.actionMotivationFragmentToHomeFragment())
        }

        viewModel.getBook(4)
        recyclerViewMotivation.adapter = bookAdapter

        viewModel.bookLiveData.observe(viewLifecycleOwner) { book ->
            bookAdapter.submitList(book)
        }
    }
}
