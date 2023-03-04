package com.example.my_new_first_chat.ui.fragments.basis

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.my_new_first_chat.R
import com.example.my_new_first_chat.databinding.FragmentBallBinding
import com.example.my_new_first_chat.extensions.showToast
import com.example.my_new_first_chat.utils.BaseFragment
import com.example.my_new_first_chat.utils.SharedPreferenceUtil
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.example.my_new_first_chat.ui.fragments.test.main.TestFragment

class BallFragment : BaseFragment(R.layout.fragment_ball) {

    private val binding by viewBinding(FragmentBallBinding::bind)
    private val lessons: Array<String> = arrayOf("0")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        val lessonIs: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_spinner_item, lessons
        )

        lessonIs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerOfFragments.adapter = lessonIs

        spinnerOfFragments.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position){
                    0 -> {
                        replacedFragments(TestFragment())
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun replacedFragments(fragment: BaseFragment){
        fragmentReplacer.replace(pagePos, fragment)
    }
}