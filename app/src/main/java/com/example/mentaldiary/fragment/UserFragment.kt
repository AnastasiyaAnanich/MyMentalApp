package com.example.mentaldiary.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mentaldiary.databinding.FragmentUserBinding
import com.example.mentaldiary.base.BaseFragment
import com.example.mentaldiary.fragment.user.UserViewModel
import com.example.mentaldiary.list.UserAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class UserFragment : BaseFragment<FragmentUserBinding>() {
    private val viewModel by viewModel<UserViewModel>()
    private val userAdapter = UserAdapter()


    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserBinding = FragmentUserBinding.inflate(inflater, container, false)


    override fun FragmentUserBinding.onBindView(saveInstanceState: Bundle?) {
        diaryButtonHomeMotivation.setOnClickListener {
            navController.navigate(UserFragmentDirections.actionMotivationFragmentToHomeFragment())
        }

        viewModel.getUsers(5)
        recyclerViewUser.adapter = userAdapter
        viewModel.userLiveData.observe(viewLifecycleOwner) { users ->
            userAdapter.submitList(users)

        }
    }
}
