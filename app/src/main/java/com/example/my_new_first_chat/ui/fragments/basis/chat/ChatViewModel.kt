package com.example.my_new_first_chat.ui.fragments.basis.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.my_new_first_chat.data.models.MessageModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ChatViewModel : ViewModel() {

    private val db = Firebase.firestore
    private val _noteLiveData = MutableLiveData<List<MessageModel>>()
    val noteLiveData: LiveData<List<MessageModel>> = _noteLiveData

    private var noteList = mutableListOf<MessageModel>()

    fun setModels(message: String, time: String) {
        noteList.add(MessageModel(text = message, timeSoft = time))
        _noteLiveData.value = noteList.toList()
    }
}