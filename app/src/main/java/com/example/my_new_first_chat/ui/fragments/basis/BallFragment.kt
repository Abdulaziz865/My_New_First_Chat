package com.example.my_new_first_chat.ui.fragments.basis

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.my_new_first_chat.R
import com.example.my_new_first_chat.databinding.FragmentBallBinding
import com.example.my_new_first_chat.extensions.examination
import com.example.my_new_first_chat.extensions.showToast

class BallFragment : Fragment(R.layout.fragment_ball) {

    private val binding by viewBinding(FragmentBallBinding::bind)
    private val lessons: Array<String> = arrayOf("1", "2", "3", "4", "5", "6", "7", "8")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        prover()
    }

    private fun initialize() = with(binding) {
        val lessonIs: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_spinner_item, lessons
        )

        lessonIs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerOfFragments.adapter = lessonIs
        spinnerOfFragments.prompt = "Фрагменты"

        spinnerOfFragments.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                showToast(parent?.selectedItem.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun prover() = with(binding) {
        if (examination == "") {
            ball.isEnabled = false
            ball.isInEditMode
            ball.isCursorVisible = false
            ball.keyListener = null
            dopBall.isEnabled = false
            dopBall.isInEditMode
            dopBall.isCursorVisible = false
            dopBall.keyListener = null
            name.isEnabled = false
            name.isInEditMode
            name.isCursorVisible = false
            name.keyListener = null
        }
    }
}