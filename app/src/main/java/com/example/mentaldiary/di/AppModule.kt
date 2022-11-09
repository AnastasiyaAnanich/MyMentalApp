package com.example.mentaldiary.di

import com.example.mentaldiary.fragment.images.ImagesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<ImagesViewModel> {
        ImagesViewModel(get())
    }
}