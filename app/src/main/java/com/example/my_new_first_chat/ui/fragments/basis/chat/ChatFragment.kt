package com.example.my_new_first_chat.ui.fragments.basis.chat

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.my_new_first_chat.R
import com.example.my_new_first_chat.databinding.FragmentChatBinding
import com.example.my_new_first_chat.extensions.showToast
import com.example.my_new_first_chat.ui.adapter.ChatAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class ChatFragment : Fragment(R.layout.fragment_chat) {

    private val db = Firebase.firestore
    private val chatAdapter = ChatAdapter()
    private val viewModel: ChatViewModel by viewModels()
    private val binding by viewBinding(FragmentChatBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
    }

    private fun initialize() {
        binding.rvChat.adapter = chatAdapter
    }

    private fun setupListeners() {
        binding.btnSendMessage.setOnClickListener {
            val message = binding.etSendMessage.text.toString()
            if (message.isEmpty()) {
                showToast("Введите текст...")
            } else {
                sendMessage()
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun sendMessage() {
        val formatter = SimpleDateFormat("hh:mm")
        val time = formatter.format(Date())
        val timeText = time.toString()
        val messageText = binding.etSendMessage.text.toString()
        viewModel.setModels(messageText, timeText)
        viewModel.noteLiveData.observe(viewLifecycleOwner) {
            chatAdapter.submitList(it)
        }
        val user = hashMapOf(
            "message" to messageText,
            "time" to timeText
        )
        // Add a new document with a generated ID
        db.collection("user").add(user).addOnSuccessListener { documentReference ->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
        }.addOnFailureListener { e ->
            Log.w(TAG, "Error adding document", e)
        }

        db.collection("user").get().addOnSuccessListener { result ->
            for (document in result) {
                Log.d(TAG, "${document.id} => ${document.data}")
            }
        }.addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents.", exception)
        }
    }

    private fun getData() {
        db.collection("user").get().addOnCompleteListener {

        }
    }
}