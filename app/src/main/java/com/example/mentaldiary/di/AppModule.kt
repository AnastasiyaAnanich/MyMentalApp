package com.example.mentaldiary.di

import com.example.mentaldiary.fragment.user.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<UserViewModel> {
        UserViewModel(get())
    }
}