package com.example.my_new_first_chat.ui.fragments.basis.chat

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.my_new_first_chat.R
import com.example.my_new_first_chat.data.models.MessageModel
import com.example.my_new_first_chat.databinding.FragmentChatBinding
import com.example.my_new_first_chat.extensions.showToast
import com.example.my_new_first_chat.ui.adapter.ChatAdapter
import com.example.my_new_first_chat.utils.BaseFragment
import com.example.my_new_first_chat.utils.SharedPreferenceUtil
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class ChatFragment : BaseFragment(R.layout.fragment_chat) {

    private val db = Firebase.firestore
    private val chatAdapter = ChatAdapter()
    private val viewModel: ChatViewModel by viewModels()
    private val binding by viewBinding(FragmentChatBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
//        getData()
        getMessage()
//        beastFeatures()
    }

    private fun initialize() {
        binding.rvChat.adapter = chatAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupListeners() {
        binding.btnSendMessage.setOnClickListener {
            val message = binding.etSendMessage.text.toString()
            if (message.isEmpty()) {
                showToast("Введите текст...")
            } else {
                sendMessage()
            }
        }
        binding.etSendMessage.text.clear()
    }

    @SuppressLint("SimpleDateFormat")
    private fun sendMessage() {
        val formatter = SimpleDateFormat("hh:mm")
        val time = formatter.format(Date())
        val timeText = time.toString()
        val messageText = binding.etSendMessage.text.toString()

        // Add a new document with a generated ID

        val user = hashMapOf(
            "message" to messageText, "time" to timeText
        )

        db.collection("user").document("all").collection("sig").add(user).addOnSuccessListener {}
    }

    private fun getData() {
        db.collection("user").addSnapshotListener() { doc, e ->
            doc?.documents?.forEach() { it ->
                it.toObject(MessageModel::class.java).let {
                    viewModel.setModels(it?.message.toString(), it?.time.toString())
                }
            }
        }
    }

    private fun getMessage() {
        db.collection("user").document("all").collection("sig").addSnapshotListener() { doc, e ->
            doc?.documents?.forEach { it ->
                it.toObject(MessageModel::class.java).let {
                    viewModel.setModels(it?.message.toString(), it?.time.toString())
                }
                viewModel.noteLiveData.observe(viewLifecycleOwner) {
                    chatAdapter.submitList(it)
                }
            }
        }
    }

    private fun beastFeatures() {
    }
}