package com.example.mentaldiary.di

import com.example.mentaldiary.fragment.diary.DiaryViewModel
import com.example.mentaldiary.fragment.home.HomeViewModel
import com.example.mentaldiary.fragment.motivation.MotivationViewModel
import com.example.mentaldiary.fragment.practice.PracticeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MotivationViewModel> {
        MotivationViewModel(get())
    }

    val appModule = module {
        viewModel<HomeViewModel> {
            HomeViewModel()
        }

        val appModule = module {
            viewModel<PracticeViewModel> {
                PracticeViewModel()
            }

            val appModule = module {
                viewModel<DiaryViewModel> {
                    DiaryViewModel(get())
                }
            }
        }
    }
}