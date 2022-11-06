package com.example.mentaldiary.fragment.diary

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mentaldiary.databinding.FragmentEditDiaryBinding
import com.example.mentaldiary.fragment.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class EditDiaryFragment : BaseFragment<FragmentEditDiaryBinding>() {
    private lateinit var diaryEdtTittle: EditText
    private lateinit var diaryEdtDescription: EditText
    private lateinit var diaryEdtButtonAddUpdate: Button
    private val viewModel by viewModel<DiaryViewModel>()
    private var diaryId = -1

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEditDiaryBinding = FragmentEditDiaryBinding.inflate(inflater, container, false)

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun FragmentEditDiaryBinding.onBindView(saveInstanceState: Bundle?) {
        diaryEdtTittle = diaryEditTittle
        diaryEdtDescription = diaryEditDescription
        diaryEdtButtonAddUpdate = diaryButtonAddUpdate

        requireActivity().run {
            startActivity(Intent(this, DiaryViewModel::class.java))
            val diaryType = intent.getStringExtra("diaryType")
            if (diaryType.equals("Edit")) {
                val diaryTittle = intent.getStringExtra("diaryTittle")
                val diaryDescription = intent.getStringExtra("diaryDescription")
                diaryId = intent.getIntExtra("diaryId", -1)
                diaryEdtButtonAddUpdate.text = "Update Diary"
                diaryEdtTittle.setText(diaryTittle)
                diaryEdtDescription.setText(diaryDescription)
            } else {
                diaryEdtButtonAddUpdate.text = "Save Diary"
            }

            diaryEdtButtonAddUpdate.setOnClickListener {
                val tittleDiary = diaryEdtTittle.text.toString()
                val descriptionDiary = diaryEdtDescription.text.toString()
                if (diaryType.equals("Edit")) {
                    if (tittleDiary.isNotEmpty() && descriptionDiary.isNotEmpty()) {
                        val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                        val currentDateAndTime: String = sdf.format(Date())
                        val diaryUpdated = Diary(tittleDiary, descriptionDiary, currentDateAndTime)
                        diaryUpdated.id = diaryId
                        viewModel.updateDiary(diaryUpdated)
                        Toast.makeText(requireContext(), "Note Updated...", Toast.LENGTH_LONG)
                            .show()
                    }
                } else {
                    if (tittleDiary.isNotEmpty() && descriptionDiary.isNotEmpty()) {
                        val sdf = SimpleDateFormat("dd MMM,yyyy - HH:mm")
                        val currentDateAndTime: String = sdf.format(Date())
                        viewModel.addDiary(Diary(tittleDiary, descriptionDiary, currentDateAndTime))
                        Toast.makeText(requireContext(), "$tittleDiary Added", Toast.LENGTH_LONG)
                            .show()
                    }
                }
                startActivity(Intent(context, DiaryFragment::class.java))
                this.finish()
            }
        }
    }
}

