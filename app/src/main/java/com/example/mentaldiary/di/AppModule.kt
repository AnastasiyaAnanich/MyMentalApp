package com.example.mentaldiary.di

import com.example.mentaldiary.fragment.motivation.MotivationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MotivationViewModel> {
     MotivationViewModel(get())
    }
}