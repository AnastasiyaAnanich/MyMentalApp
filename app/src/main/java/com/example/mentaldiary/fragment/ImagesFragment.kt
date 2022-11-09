package com.example.mentaldiary.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mentaldiary.databinding.FragmentUserBinding
import com.example.mentaldiary.base.BaseFragment
import com.example.mentaldiary.fragment.user.ImagesViewModel
import com.example.mentaldiary.list.ImagesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class ImagesFragment : BaseFragment<FragmentUserBinding>() {
    private val viewModel by viewModel<ImagesViewModel>()
    private val imagesAdapter = ImagesAdapter()


    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserBinding = FragmentUserBinding.inflate(inflater, container, false)


    override fun FragmentUserBinding.onBindView(saveInstanceState: Bundle?) {
        diaryButtonHomeMotivation.setOnClickListener {
            navController.navigate(ImagesFragmentDirections.actionMotivationFragmentToHomeFragment())
        }

        viewModel.getImages(5)
        recyclerViewImages.adapter = imagesAdapter
        viewModel.userLiveData.observe(viewLifecycleOwner) { images ->
            imagesAdapter.submitList(images)

        }
    }
}
