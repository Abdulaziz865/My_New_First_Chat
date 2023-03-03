package com.example.my_new_first_chat.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

const val CHILD_MESSAGE = "text"
const val CHILD_TYPE = "type"
const val CHILD_FROM = "from"
const val CHILD_TIME = "timeSoft"
const val CURRENT_ID = "id"
const val NODE_MESSAGE = "messages"

fun Fragment.showToast(text : String){
    Toast.makeText(requireContext(), text , Toast.LENGTH_SHORT).show()
}