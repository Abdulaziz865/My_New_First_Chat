package com.example.my_new_first_chat.ui.fragments.basis

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.my_new_first_chat.R
import com.example.my_new_first_chat.databinding.FragmentBallBinding
import com.example.my_new_first_chat.extensions.showToast
import com.example.my_new_first_chat.utils.SharedPreferenceUtil
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class BallFragment : Fragment(R.layout.fragment_ball) {

    private val binding by viewBinding(FragmentBallBinding::bind)
    private val lessons: Array<String> = arrayOf("1", "2", "3", "4", "5", "6", "7", "8")
    private val database = Firebase.database
    private val ballData = database.getReference("ball")
    private val ballDataDop = database.getReference("ballDop")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        prover()
        setupListener()
        readData()
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
        if (!SharedPreferenceUtil.isProver) {
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

    private fun setupListener() = with(binding) {
        btnSaveDataBall.setOnClickListener {
            let {
                ballData.setValue(ball.text.toString())
                ballDataDop.setValue(dopBall.text.toString())
            }
        }
    }

    private fun readData() = with(binding) {
        ballData.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ball.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        ballDataDop.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                dopBall.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}