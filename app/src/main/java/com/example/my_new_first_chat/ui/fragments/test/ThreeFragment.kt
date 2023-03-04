package com.example.my_new_first_chat.ui.fragments.test

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.my_new_first_chat.R
import com.example.my_new_first_chat.databinding.FragmentThreeBinding
import com.example.my_new_first_chat.utils.BaseFragment
import com.example.my_new_first_chat.utils.SharedPreferenceUtil
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class ThreeFragment : BaseFragment(R.layout.fragment_three) {

    private val binding by viewBinding(FragmentThreeBinding::bind)
    private val database = Firebase.database

    private val nameDataPerson1 = database.getReference("3name1")
    private val nameDataPerson2 = database.getReference("3name2")
    private val nameDataPerson3 = database.getReference("3name3")
    private val nameDataPerson4 = database.getReference("3name4")
    private val nameDataPerson5 = database.getReference("3name5")
    private val nameDataPerson6 = database.getReference("3name6")
    private val nameDataPerson7 = database.getReference("3name7")
    private val nameDataPerson8 = database.getReference("3name8")

    private val ballData1 = database.getReference("3ball1")
    private val ballData2 = database.getReference("3ball2")
    private val ballData3 = database.getReference("3ball3")
    private val ballData4 = database.getReference("3ball4")
    private val ballData5 = database.getReference("3ball5")
    private val ballData6 = database.getReference("3ball6")
    private val ballData7 = database.getReference("3ball7")
    private val ballData8 = database.getReference("3ball8")

    private val ballDataDop1 = database.getReference("3ballDop1")
    private val ballDataDop2 = database.getReference("3ballDop2")
    private val ballDataDop3 = database.getReference("3ballDop3")
    private val ballDataDop4 = database.getReference("3ballDop4")
    private val ballDataDop5 = database.getReference("3ballDop5")
    private val ballDataDop6 = database.getReference("3ballDop6")
    private val ballDataDop7 = database.getReference("3ballDop7")
    private val ballDataDop8 = database.getReference("3ballDop8")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
        readData()
        setEdittexts()
    }

    private fun setupListener() = with(binding){
        if (SharedPreferenceUtil.isProver) {
            btnSaveDataBall.visibility = View.VISIBLE
        }
        btnBackSpace.setOnClickListener {
            fragmentReplacer.replaceCurrentToDef()
        }
        btnSaveDataBall.setOnClickListener {
            nameDataPerson1.setValue(namePerson1.text.toString())
            nameDataPerson2.setValue(namePerson2.text.toString())
            nameDataPerson3.setValue(namePerson3.text.toString())
            nameDataPerson4.setValue(namePerson4.text.toString())
            nameDataPerson5.setValue(namePerson5.text.toString())
            nameDataPerson6.setValue(namePerson6.text.toString())
            nameDataPerson7.setValue(namePerson7.text.toString())
            nameDataPerson8.setValue(namePerson8.text.toString())

            ballData1.setValue(ballPerson1.text.toString())
            ballData2.setValue(ballPerson2.text.toString())
            ballData3.setValue(ballPerson3.text.toString())
            ballData4.setValue(ballPerson4.text.toString())
            ballData5.setValue(ballPerson5.text.toString())
            ballData6.setValue(ballPerson6.text.toString())
            ballData7.setValue(ballPerson7.text.toString())
            ballData8.setValue(ballPerson8.text.toString())

            ballDataDop1.setValue(ballDoppPerson1.text.toString())
            ballDataDop2.setValue(ballDoppPerson2.text.toString())
            ballDataDop3.setValue(ballDoppPerson3.text.toString())
            ballDataDop4.setValue(ballDoppPerson4.text.toString())
            ballDataDop5.setValue(ballDoppPerson5.text.toString())
            ballDataDop6.setValue(ballDoppPerson6.text.toString())
            ballDataDop7.setValue(ballDoppPerson7.text.toString())
            ballDataDop8.setValue(ballDoppPerson8.text.toString())
        }
    }

    private fun readData() = with(binding) {
        nameDataPerson1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                namePerson1.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        nameDataPerson2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                namePerson2.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        nameDataPerson3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                namePerson3.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        nameDataPerson4.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                namePerson4.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        nameDataPerson5.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                namePerson5.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        nameDataPerson6.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                namePerson6.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        nameDataPerson7.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                namePerson7.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        nameDataPerson8.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                namePerson8.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        ballData1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballPerson1.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        ballData2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballPerson2.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        ballData3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballPerson3.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        ballData4.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballPerson4.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        ballData5.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballPerson5.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        ballData6.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballPerson6.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        ballData7.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballPerson7.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        ballData8.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballPerson8.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        ballDataDop1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballDoppPerson1.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        ballDataDop2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballDoppPerson2.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        ballDataDop3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballDoppPerson3.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        ballDataDop4.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballDoppPerson4.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        ballDataDop5.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballDoppPerson5.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        ballDataDop6.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballDoppPerson6.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        ballDataDop7.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballDoppPerson7.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        ballDataDop8.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                ballDoppPerson8.setText(value.toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
    private fun setEdittexts() = with(binding) {
        if (!SharedPreferenceUtil.isProver){
            namePerson1.isEnabled = false
            namePerson1.isInEditMode
            namePerson1.isCursorVisible = false
            namePerson1.keyListener = null

            namePerson2.isEnabled = false
            namePerson2.isInEditMode
            namePerson2.isCursorVisible = false
            namePerson2.keyListener = null

            namePerson3.isEnabled = false
            namePerson3.isInEditMode
            namePerson3.isCursorVisible = false
            namePerson3.keyListener = null

            namePerson4.isEnabled = false
            namePerson4.isInEditMode
            namePerson4.isCursorVisible = false
            namePerson4.keyListener = null

            namePerson5.isEnabled = false
            namePerson5.isInEditMode
            namePerson5.isCursorVisible = false
            namePerson5.keyListener = null

            namePerson6.isEnabled = false
            namePerson6.isInEditMode
            namePerson6.isCursorVisible = false
            namePerson6.keyListener = null

            namePerson7.isEnabled = false
            namePerson7.isInEditMode
            namePerson7.isCursorVisible = false
            namePerson7.keyListener = null

            namePerson8.isEnabled = false
            namePerson8.isInEditMode
            namePerson8.isCursorVisible = false
            namePerson8.keyListener = null

            ballPerson1.isEnabled = false
            ballPerson1.isInEditMode
            ballPerson1.isCursorVisible = false
            ballPerson1.keyListener = null

            ballPerson2.isEnabled = false
            ballPerson2.isInEditMode
            ballPerson2.isCursorVisible = false
            ballPerson2.keyListener = null

            ballPerson3.isEnabled = false
            ballPerson3.isInEditMode
            ballPerson3.isCursorVisible = false
            ballPerson3.keyListener = null

            ballPerson4.isEnabled = false
            ballPerson4.isInEditMode
            ballPerson4.isCursorVisible = false
            ballPerson4.keyListener = null

            ballPerson5.isEnabled = false
            ballPerson5.isInEditMode
            ballPerson5.isCursorVisible = false
            ballPerson5.keyListener = null

            ballPerson6.isEnabled = false
            ballPerson6.isInEditMode
            ballPerson6.isCursorVisible = false
            ballPerson6.keyListener = null

            ballPerson7.isEnabled = false
            ballPerson7.isInEditMode
            ballPerson7.isCursorVisible = false
            ballPerson7.keyListener = null

            ballPerson8.isEnabled = false
            ballPerson8.isInEditMode
            ballPerson8.isCursorVisible = false
            ballPerson8.keyListener = null

            ballDoppPerson1.isEnabled = false
            ballDoppPerson1.isInEditMode
            ballDoppPerson1.isCursorVisible = false
            ballDoppPerson1.keyListener = null

            ballDoppPerson2.isEnabled = false
            ballDoppPerson2.isInEditMode
            ballDoppPerson2.isCursorVisible = false
            ballDoppPerson2.keyListener = null

            ballDoppPerson3.isEnabled = false
            ballDoppPerson3.isInEditMode
            ballDoppPerson3.isCursorVisible = false
            ballDoppPerson3.keyListener = null

            ballDoppPerson4.isEnabled = false
            ballDoppPerson4.isInEditMode
            ballDoppPerson4.isCursorVisible = false
            ballDoppPerson4.keyListener = null

            ballDoppPerson5.isEnabled = false
            ballDoppPerson5.isInEditMode
            ballDoppPerson5.isCursorVisible = false
            ballDoppPerson5.keyListener = null

            ballDoppPerson6.isEnabled = false
            ballDoppPerson6.isInEditMode
            ballDoppPerson6.isCursorVisible = false
            ballDoppPerson6.keyListener = null

            ballDoppPerson7.isEnabled = false
            ballDoppPerson7.isInEditMode
            ballDoppPerson7.isCursorVisible = false
            ballDoppPerson7.keyListener = null

            ballDoppPerson8.isEnabled = false
            ballDoppPerson8.isInEditMode
            ballDoppPerson8.isCursorVisible = false
            ballDoppPerson8.keyListener = null
        }
    }
}