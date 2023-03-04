package com.example.my_new_first_chat.ui.fragments.test.main

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.my_new_first_chat.R
import com.example.my_new_first_chat.databinding.FragmentTestBinding
import com.example.my_new_first_chat.extensions.showToast
import com.example.my_new_first_chat.ui.fragments.test.*
import com.example.my_new_first_chat.utils.BaseFragment
import com.example.my_new_first_chat.utils.SharedPreferenceUtil

class TestFragment : BaseFragment(R.layout.fragment_test) {

    private val binding by viewBinding(FragmentTestBinding::bind)
    private val lessons: Array<String> = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() = with(binding) {

        if (SharedPreferenceUtil.isProver) {
            btnSaveDataBall.visibility = View.VISIBLE
        }

        val lessonIs: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_spinner_item, lessons
        )

        lessonIs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerOfFragments.adapter = lessonIs
        spinnerOfFragments.prompt = "Уроки"

        spinnerOfFragments.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {

                    }
                    1 -> {
                        replacedFragments(OneFragment())
                    }
                    2 -> {
                        replacedFragments(TwoFragment())
                    }
                    3 -> {
                        replacedFragments(ThreeFragment())
                    }
                    4 -> {
                        replacedFragments(FourFragment())
                    }
                    5 -> {
                        replacedFragments(FiveFragment())
                    }
                    6 -> {
                        replacedFragments(SixFragment())
                    }
                    7 -> {
                        replacedFragments(SevenFragment())
                    }
                    8 -> {
                        replacedFragments(EightFragment())
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun replacedFragments(fragment: BaseFragment) {
        fragmentReplacer.replace(pagePos, fragment)
    }

    private fun setupListener() = with(binding) {
        btnBackSpace.setOnClickListener {
            fragmentReplacer.replaceCurrentToDef()
        }
    }
}